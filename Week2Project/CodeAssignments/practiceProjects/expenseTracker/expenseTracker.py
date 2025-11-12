# Originally created: 11/11/2025
# Version: 1.0.0

from datetime import datetime
import pandas as pd
import sqlite3 as sql

csv_file = 'expenses.csv'
db_name = 'expenses.db'

def create_table():
    try:
        # Creates the file if it does not exist.
        with sql.connect(db_name) as conn:
            cur = conn.cursor()
            cur.execute('''
                        CREATE TABLE IF NOT EXISTS expenses (
                            EXPENSE_ID INTEGER PRIMARY KEY AUTOINCREMENT, 
                            EXPENSE_DATE DATE NOT NULL, 
                            AMOUNT DOUBLE NOT NULL, 
                            CATEGORY VARCHAR(100) NOT NULL, 
                            DESCRIPTION VARCHAR(100)
                        );
            ''')
            conn.commit()
    except sql.Error as e:
        print(f"SQLite Error: {e}")

def add_expense(date, amount, category, description=''):
    with sql.connect(db_name) as conn:
        expense_list = pd.read_sql_query("SELECT * FROM expenses;", conn)
        new_expense = pd.DataFrame({'EXPENSE_ID': [len(expense_list) + 1], 'EXPENSE_DATE': [date], 'AMOUNT': [amount], 'CATEGORY': [category], 'DESCRIPTION': [description]})
        new_expense.set_index('EXPENSE_ID', inplace=True, drop=False)
        new_expense.to_sql('expenses', conn, if_exists='append', index=False)
        conn.commit()

    expense_list = view_expenses()

    return expense_list

def view_expenses():
    with sql.connect(db_name) as conn:
        query = "SELECT * FROM expenses;"
        expenses = pd.read_sql_query(query, conn)

    return expenses

def view_expenses_partial(num_rows = 5):
    expenses = view_expenses()

    return f"{expenses.head(num_rows)}\n...\n{expenses.tail(num_rows)}"

def delete_expense(expense_id):
    conn = sql.connect(db_name)
    cursor = conn.cursor()
    query = "DELETE FROM expenses WHERE EXPENSE_ID = ?;"
    cursor.execute(query, (expense_id,))
    conn.commit()
    conn.close()

    expenses = view_expenses()

    return expenses

def update_expense(expense_id, expense_date, amount, category, description):
    df_existing = view_expenses()
    new_expense = pd.Series({'EXPENSE_ID': expense_id, 'EXPENSE_DATE': expense_date, 'AMOUNT': amount, 'CATEGORY': category, 'DESCRIPTION': description}, name=(expense_id - 1))
    df_existing.loc[expense_id - 1] = new_expense

    with sql.connect(db_name) as conn:
        df_existing.to_sql('expenses', conn, if_exists='replace', index=False)
        conn.commit()

    expenses = view_expenses()

    return expenses

def get_date():
    expense_year = abs(int(input("Enter expense year: ")))
    expense_month = -1
    is_valid_month = 0 < expense_month <= 12
    while not is_valid_month:
        expense_month = abs(int(input("Enter expense month: ")))
        is_valid_month = 0 < expense_month <= 12
        if not is_valid_month:
            print("Invalid month.")
    expense_day = -1
    is_valid_day = 0 < expense_day <= 31
    while not is_valid_day:
        expense_day = abs(int(input("Enter expense day: ")))
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
        if not is_valid_day:
            print("Invalid day.")
    expense_date = f"{expense_year:0{4}}-{expense_month:0{2}}-{expense_day:0{2}}"
    return expense_date

def get_inputs():
    expense_date = get_date()
    expense_amount = abs(float(input("Enter expense amount: ")))
    expense_category = input("Enter expense category: ").capitalize()
    expense_description = input("Enter expense description (optional): ").capitalize()

    return expense_date, expense_amount, expense_category, expense_description

# Save data to a CSV
def save_expenses(dataframe):
    print("\nSaving expenses...")
    dataframe.to_csv(csv_file, index=False)

def add_demo():
    print("\nAdding expense...")

    in_date, in_amount, in_category, in_description = get_inputs()
    expenses = add_expense(in_date, in_amount, in_category, in_description)

    # print(f"\nAdded {added_count} expense{'s' if added_count > 1 else ''}.")
    print(view_expenses())
    save_expenses(expenses)

def view_demo(num=3):
    print("\nViewing expenses...")

    print(view_expenses_partial(num))

def delete_demo():
    print("\nDeleting expense...")

    id_num = abs(int(input("Enter expense id: ")))

    expense_list = delete_expense(id_num)

    # print(f"\nRemoved {removed_count} expense{'s' if removed_count > 1 else ''}.")
    print(expense_list)
    save_expenses(expense_list)

def update_demo():
    print("\nUpdating expense...")

    id_num = abs(int(input("Enter expense id: ")))
    new_date, new_amount, new_category, new_description = get_inputs()

    expense_list = update_expense(id_num, new_date, new_amount, new_category, new_description)

    print(expense_list)
    save_expenses(expense_list)

def summary():
    expense_list = view_expenses()
    total_expenses = sum(expense_list['AMOUNT'])
    totals_by_category = df.groupby('CATEGORY')[['AMOUNT']].sum()

    dt1_str = get_date()
    dt2_str = get_date()
    format_str = "%Y-%m-%d"
    dt1 = datetime.strptime(dt1_str, format_str).date()
    dt2 = datetime.strptime(dt2_str, format_str).date()

    total_by_range = 0
    for index, expense in expense_list.iterrows():
        dt_str = expense['EXPENSE_DATE']
        dt_current = datetime.strptime(dt_str, format_str).date()
        if dt_current >= dt1 and dt_current <= dt2:
            total_by_range += expense['AMOUNT']

    print("\n===SUMMARY====")
    print(f"Total expenses: {total_expenses}")
    print(f"Total expenses by category: \n{totals_by_category}\n")
    print(f"Total from {dt1} to {dt2}: {total_by_range}")

def demo():
    view_demo()
    add_demo()
    delete_demo()
    update_demo()

def demo_first_time():
    create_table()
    with sql.connect(db_name) as conn:
        cursor = conn.cursor()
        expenses_data = [
            ('1990-12-31', 25.0, 'Category1', 'Desc1'),
            ('2000-01-06', 1.0, 'Category2', ''),
            ('2003-11-26', 74.0, 'Category1', 'Desc3'),
            ('2004-07-16', 1.5, 'Category2', 'Desc4'),
            ('2020-06-17', 6.7, 'Category1', '')
        ]
        query = "INSERT INTO expenses (EXPENSE_DATE, AMOUNT, CATEGORY, DESCRIPTION) VALUES (?, ?, ?, ?)"
        cursor.executemany(query, expenses_data)
        conn.commit()
    expense_list = view_expenses()
    view_demo(1)
    add_demo()
    delete_demo()
    update_demo()
    summary()

if __name__ == '__main__':
    try:
        df = pd.read_csv(csv_file)
    except FileNotFoundError as e:
        print("File not found. Creating database...")
        demo_first_time()
    else:
        # demo()
        summary()