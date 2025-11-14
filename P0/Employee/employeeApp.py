# Originally created: 11/11/2025
# Version: 0.0.0

import pandas as pd
from Employee.employeeDBManager import *

# TODO
# [] Log in with my credentials so that I can securely access my expense reports.
# [] Submit a new expense with details about amount and description so that I can request reimbursement or track spending.
# [] View the status of my submitted expenses so that I know whether they are pending, approved, or denied.
# [] Edit expenses that are still pending so that I can correct mistakes before they are reviewed.
# [] Delete expenses that are still pending so that I can correct mistakes before they are reviewed.
# [] History of all my approved and denied expenses so that I can track my financial activity over time.

def login():
    is_logged_in = False  # Flag indicates whether the user is logged in; set to True on a successful login
    while not is_logged_in:
        name_input = input("Enter username: ").capitalize().strip()
        pass_input = input("Enter password: ").strip()
        is_logged_in = verify_user(name_input, pass_input)
        if not is_logged_in:
            print("Invalid username or password.")
    return name_input, pass_input

def submit():
    pass

# Displayed result should probably be sorted by status
def view_status():
    pass

def edit():
    pass

def delete():
    pass

# Displayed result should probably be sorted by date
def history():
    pass

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
    username, password = login()
    is_done = False  # Flag indicates whether the user is done; the application should quit when this is True
    while not is_done:
        print_main_menu()
        user_input = input("Enter your choice: ").lower().strip()
        match user_input:
            case "1":
                submit()
            case "2":
                view_status()
            case "3":
                edit()
            case "4":
                delete()
            case "5":
                history()
            case "6":
                is_done = True
            case "demo":
                view_status()
                history()
                submit()
                edit()
                delete()
                print_database()
                is_done = True
            case _:
                print("Error: Input not recognized. Please enter a valid choice.")