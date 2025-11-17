# Originally created: 11/11/2025
# Version: 0.0.0

import pandas as pd
from Employee.employeeDBManager import *

# TODO
# [X] Log in with my credentials so that I can securely access my expense reports.
# [X] Submit a new expense with details about amount and description so that I can request reimbursement or track spending.
# [] View the status of my submitted expenses so that I know whether they are pending, approved, or denied.
# [X] Edit expenses that are still pending so that I can correct mistakes before they are reviewed.
# [X] Delete expenses that are still pending so that I can correct mistakes before they are reviewed.
# [] History of all my approved and denied expenses so that I can track my financial activity over time.

def login():
    is_logged_in = False  # Flag indicates whether the user is logged in; set to True on a successful login
    while not is_logged_in:
        name_input = input("Enter username: ").capitalize().strip()
        pass_input = input("Enter password: ").strip()
        user_data = verify_user(name_input, pass_input)
        is_logged_in = user_data is not None
        if not is_logged_in:
            print("Invalid username or password.")
    print(f"\nHello, {name_input}!")
    return user_data

def submit(df):
    expense_amt, expense_desc, expense_date = get_expense_details()
    user_id = df.at[0, "id"]
    submit_expense(user_id, expense_amt, expense_desc, expense_date)

# Displayed result should probably be sorted by status
def view_status(df):
    user_id = df.at[0, "id"]
    view_df = view_expenses_statuses(user_id)

    print(view_df)

    for name, group in view_df.groupby("status"):
        print(f"\nGroup: {name}")
        print(group)

def edit(df):
    expense_id = get_expense_id(df.at[0, "id"])
    expense_amt, expense_desc, expense_date = get_expense_edits()
    edit_expense(expense_id, expense_amt, expense_desc, expense_date)

def delete(df):
    user_id = df.at[0, "id"]
    pending_expenses_df = view_expenses_pending(user_id)
    valid_expense_ids = pending_expenses_df['id']
    while True:
        print(pending_expenses_df)
        try:
            expense_id = int(input("Enter the id of the expense you wish to delete: ").strip())
            break
        except ValueError:
            print("Invalid id.")
    delete_expense(expense_id)

# Displayed result should probably be sorted by date
def history(df):
    user_id = df.at[0, "id"]
    history_df = view_expenses_history(user_id)
    sorted_history = history_df.sort_values(by=["date"], inplace=True)
    print(history_df)

# Date returned shall be in the following format: YYYY-MM-DD
def get_date():
    while True:
        try:
            date_str = input("Enter expense date: ").strip()
            date_parts = date_str.split("-", 2)
            expense_year = int(date_parts[0])
            expense_month = int(date_parts[1])
            expense_day = int(date_parts[2])
            is_valid_month = 0 < expense_month <= 12
            months_with_30_days = {4, 6, 9, 11}
            if expense_day in months_with_30_days:
                is_valid_day = 0 < expense_day <= 30
            elif expense_month == 2:
                if expense_year % 4 == 0 and expense_year % 100 != 0 or expense_year % 400 == 0:
                    is_valid_day = 0 < expense_day <= 29
                else:
                    is_valid_day = 0 < expense_day <= 28
            else:
                is_valid_day = 0 < expense_day <= 31
            if is_valid_month and is_valid_day:
                break
            else:
                print(f"{"Invalid month." if not is_valid_month else ""} {"Invalid day." if not is_valid_day else ""}")
        except ValueError:
            print("Invalid date.")
    date = f"{expense_year:0{4}}-{expense_month:0{2}}-{expense_day:0{2}}"
    return date

def get_expense_id(user_id):
    pending_expenses_df = view_expenses_pending(user_id)
    valid_expense_ids = pending_expenses_df['id']
    while True:
        print(pending_expenses_df)
        try:
            expense_id = int(input("Enter the id of the expense you wish to edit: ").strip())
            if expense_id not in valid_expense_ids:
                print("Invalid id.")
            else:
                break
        except ValueError:
            print("Invalid id.")
    return expense_id

def get_expense_details():
    while True:
        try:
            amt = round(float(input("Enter expense amount: ").strip()), 2)
            # If expense_amt cast successfully, then break out of the loop
            break
        except ValueError:
            print("Invalid amount.")
    desc = input("Enter expense description: ").strip()
    date = get_date()   # YYYY-MM-DD
    return amt, desc, date

def get_expense_edits():
    while True:
        try:
            amt_str = input("Enter new amount: ")
            if amt_str is None:
                amt = None
            else:
                amt = round(float(amt_str), 2)
            break
        except ValueError:
            print("Invalid amount.")
    desc = input("Enter expense description: ").strip()
    while True:
        try:
            date_str = input("Enter expense date: ")
            if date_str is None:
                break
            date_parts = date_str.split("-", 2)
            expense_year = int(date_parts[0])
            expense_month = int(date_parts[1])
            expense_day = int(date_parts[2])
            is_valid_month = 0 < expense_month <= 12
            months_with_30_days = {4, 6, 9, 11}
            if expense_day in months_with_30_days:
                is_valid_day = 0 < expense_day <= 30
            elif expense_month == 2:
                if expense_year % 4 == 0 and expense_year % 100 != 0 or expense_year % 400 == 0:
                    is_valid_day = 0 < expense_day <= 29
                else:
                    is_valid_day = 0 < expense_day <= 28
            else:
                is_valid_day = 0 < expense_day <= 31
            if is_valid_month and is_valid_day:
                break
            else:
                print(f"{"Invalid month." if not is_valid_month else ""} {"Invalid day." if not is_valid_day else ""}")
        except ValueError:
            print("Invalid date.")
    if date_str is not None:
        date = f"{expense_year:0{4}}-{expense_month:0{2}}-{expense_day:0{2}}"
    else:
        date = None
    return amt, desc, date

def print_main_menu():
    header_string = "========= ACTIONS ========="
    actions = [
        "Submit a new expense",
        "View status of submitted expenses",
        "Edit a pending expense",
        "Delete a pending expense",
        "View your expense history",
        "Quit application"
    ]
    print(header_string)
    for i in range(len(actions)):
        print(f"{i+1}. {actions[i]}")
    print("=" * len(header_string))

def print_database():
    users, expenses, approvals = get_db()
    pd.set_option('display.max_rows', None)
    pd.set_option('display.max_columns', None)
    pd.set_option('display.max_colwidth', None)
    print(f"\nusers:\n{users}\nexpenses:\n{expenses}\napprovals:\n{approvals}\n")

if __name__ == '__main__':
    user_df = login()
    is_done = False  # Flag indicates whether the user is done; the application should quit when this is True
    while not is_done:
        print_main_menu()
        user_input = input("Enter your choice: ").lower().strip()
        match user_input:
            case "1":
                submit(user_df)
            case "2":
                view_status(user_df)
            case "3":
                edit(user_df)
            case "4":
                delete(user_df)
            case "5":
                history(user_df)
            case "6":
                is_done = True
            case "demo":
                print_database()
                view_status(user_df)
                history(user_df)
                submit(user_df)
                edit(user_df)
                delete(user_df)
                print_database()
                is_done = True
            case _:
                print("Error: Input not recognized. Please enter a valid choice.")