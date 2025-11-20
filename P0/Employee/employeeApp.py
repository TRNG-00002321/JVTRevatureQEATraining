# Originally created: 11/11/2025
# Version: 1.0.2

import logging
from datetime import datetime, date
from Employee.employeeDBManager import *

logging.basicConfig(filename='employeeApp.log', level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')

def login():
    while True:
        name_input = input("Enter username: ").capitalize().strip()
        pass_input = input("Enter password: ").strip()
        user_data = verify_user(name_input, pass_input)
        if user_data is None:
            print("Invalid username or password.")
            logging.error(f"Invalid login: username=\"{name_input}\", password=\"{pass_input}\"")
        else:
            break
    print(f"\nHello, {name_input}!")
    logging.info(f"User {user_data.at[0, "id"]} ({name_input}) logged in.")
    return user_data

def submit(df):
    e_amt, e_desc, e_date = get_expense_details()
    user_id = df.at[0, "id"]
    submit_expense(user_id, e_amt, e_desc, e_date)
    logging.info(f"Submitted new expense: user_id={user_id}, amount={e_amt}, description={e_desc}, date={e_date}")

# Displayed result should probably be sorted by status then by date
def view_status(df):
    user_id = df.at[0, "id"]
    view_df = view_expenses_statuses(user_id)

    for name, group in view_df.groupby("status"):
        print(f"\n{str(name).capitalize()} Expenses:")
        print(group.sort_values(by=["date"]))

    logging.info(f"User {user_id} called view_status().")

def edit(df):
    e_id = get_expense_id(df.at[0, "id"])
    e_amt, e_desc, e_date = get_expense_edits()
    edit_expense(e_id, e_amt, e_desc, e_date)
    logging.info(f"Edited expense {e_id}: user_id={df.at[0, "id"]}, amount={e_amt}, description={e_desc}, date={e_date}")

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
            logging.error("Invalid id entered by user during a deletion.")

    if expense_id in valid_expense_ids:
        delete_expense(expense_id)
        logging.info(f"Deletion of expense {expense_id} called by user {user_id}.")
    else:
        print("Invalid id.")
        logging.error(f"Expense {expense_id} not valid for deletion.")

# Displayed result should probably be sorted by date
def history(df):
    user_id = df.at[0, "id"]
    history_df = view_expenses_history(user_id)
    history_df.sort_values(by=["date"], inplace=True)
    print(history_df)
    logging.info(f"Displayed history of user {user_id}.")

# Date returned shall be in the following format: YYYY-MM-DD
def get_date():
    while True:
        try:
            date_str = input("Enter expense date (YYYY-MM-dd): ").strip()
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
                input_date = f"{expense_year:0{4}}-{expense_month:0{2}}-{expense_day:0{2}}"
                date_object = datetime.strptime(input_date, "%Y-%m-%d").date()
                today = date.today()
                if date_object <= today:
                    break
                else:
                    print("Cannot enter a future date.")
                    logging.error("Future date entered by user.")
            else:
                print(f"{"Invalid month." if not is_valid_month else ""} {"Invalid day." if not is_valid_day else ""}")
                logging.error("Invalid date entered by user.")
        except ValueError:
            print("Invalid date.")
            logging.error("Invalid date entered by user.")
    return input_date

def get_expense_id(user_id):
    pending_expenses_df = view_expenses_pending(user_id)
    valid_expense_ids = pending_expenses_df['id'].tolist()
    # print(f"valid_expense_ids = {valid_expense_ids}")
    while True:
        print(pending_expenses_df)
        try:
            expense_id = int(input("Enter the id of the expense you wish to edit: ").strip())
            if expense_id not in valid_expense_ids:
                print("Invalid id.")
                logging.error(f"User {user_id} entered invalid expense ID.")
            else:
                break
        except ValueError:
            print("Invalid id.")
            logging.error(f"User {user_id} entered invalid expense ID.")
    return expense_id

def get_expense_details():
    while True:
        try:
            amt = round(float(input("Enter expense amount: ").strip()), 2)
            # If expense_amt cast successfully, then break out of the loop
            if amt < 0:
                print("Invalid amount.")
                logging.error("Invalid amount entered by user.")
            else:
                break
        except ValueError:
            print("Invalid amount.")
            logging.error("Invalid amount entered by user.")
    while True:
        desc = input("Enter expense description: ").strip()
        if len(desc) < 1:
            print("Invalid description.")
            logging.error("Invalid description entered by user.")
        else:
            break
    input_date = get_date()   # YYYY-MM-DD
    return amt, desc, input_date

def get_expense_edits():
    while True:
        try:
            amt_str = input("Enter new amount: ")
            if not amt_str.strip():
                amt = None
                break
            elif float(amt_str.strip()) > 0:
                amt = round(float(amt_str.strip()), 2)
                break
            else:
                print("Invalid amount.")
                logging.error("Invalid amount entered by user.")
        except ValueError:
            print("Invalid amount.")
            logging.error("Invalid amount entered by user.")
    desc = input("Enter expense description: ").strip()
    if not desc.strip():
        desc = None
    while True:
        try:
            date_str = input("Enter expense date (YYYY-MM-dd): ")
            if not date_str.strip():
                input_date = None
                break
            date_parts = date_str.strip().split("-", 2)
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
                input_date = f"{expense_year:0{4}}-{expense_month:0{2}}-{expense_day:0{2}}"
                date_object = datetime.strptime(input_date, "%Y-%m-%d").date()
                today = date.today()
                if date_object <= today:
                    break
                else:
                    print("Cannot enter a future date.")
                    logging.error("Future date entered by user.")
            else:
                print(f"{"Invalid month." if not is_valid_month else ""} {"Invalid day." if not is_valid_day else ""}")
                logging.error("Invalid date entered by user.")
        except ValueError:
            print("Invalid date.")
            logging.error("Invalid date entered by user.")
    return amt, desc, input_date

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
    # pd.set_option('display.max_columns', None) # Should be called already; uncomment if that is not the case
    # pd.set_option("display.width", 1000) # Should be called already; uncomment if that is not the case
    pd.set_option('display.max_colwidth', None)
    print(f"\nusers:\n{users}\nexpenses:\n{expenses}\napprovals:\n{approvals}\n")
    logging.info("Printed database.")

if __name__ == '__main__':
    pd.set_option("display.max_columns", None)
    pd.set_option("display.max_colwidth", 100)
    pd.set_option("display.width", 1000)
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
                logging.info("Quitting employee application.")
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
                logging.error(f"User {user_df.at[0, "id"]} attempted invalid menu choice.")