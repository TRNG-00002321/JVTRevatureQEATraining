# Originally created: 11/13/2025
# Version: 0.0.0

import sqlite3 as sql
import pandas as pd

db = '../expenses_database.db'

# TODO
# [X] Login
# [X] Submit a new expense with details about amount and description
# [X] View the status of my submitted expenses so that I know whether they are pending, approved, or denied.
# [X] Edit expenses that are still pending so that I can correct mistakes before they are reviewed.
# [X] Delete expenses that are still pending so that I can correct mistakes before they are reviewed.
# [X] History of all my approved and denied expenses so that I can track my financial activity over time.

def verify_user(username, password):
    query = "SELECT * FROM users WHERE username = ? AND password = ?;"
    with sql.connect(db) as conn:
        df = pd.read_sql(query, conn, params=(username, password))
    if df.empty:
        return None
    else:
        return df

def submit_expense(user_id, amount, description, date):
    query = "INSERT INTO expenses (user_id, amount, description, date) VALUES (?, ?, ?, ?);"
    with sql.connect(db) as conn:
        cur = conn.cursor()
        cur.execute(query, (user_id, amount, description, date))
        conn.commit()

        if cur.lastrowid is not None:
            expense_id = cur.lastrowid
            query = "INSERT INTO approvals (expense_id, status) VALUES (?, ?);"
            cur.execute(query, (expense_id, "pending"))
            conn.commit()
        else:
            print("Error when inserting expense: cur.lastrowid is None")

def view_expenses_statuses(user_id):
    query = "SELECT e.id, e.amount, e.description, e.date, a.status, a.comment FROM expenses e JOIN approvals a ON e.id = a.expense_id WHERE e.user_id = ?;"
    with sql.connect(db) as conn:
        cur = conn.cursor()
        cur.execute(query, (user_id, ))
        expenses = cur.fetchall()
        column_names = [description[0] for description in cur.description]
    df = pd.DataFrame(expenses, columns=column_names)
    return df

def view_expenses_pending(user_id):
    query = "SELECT e.id, e.amount, e.description, e.date FROM expenses e JOIN approvals a ON e.id = a.expense_id WHERE e.user_id = ? AND a.status = ?;"
    with sql.connect(db) as conn:
        cur = conn.cursor()
        cur.execute(query, (user_id, "pending"))
        expenses = cur.fetchall()
        column_names = [description[0] for description in cur.description]
    df = pd.DataFrame(expenses, columns=column_names)
    return df

def view_expenses_history(user_id):
    query = "SELECT e.id, e.amount, e.description, e.date, a.status, a.comment FROM expenses e JOIN approvals a ON e.id = a.expense_id WHERE e.user_id = ? AND (a.status = ? OR a.status = ?);"
    with sql.connect(db) as conn:
        cur = conn.cursor()
        cur.execute(query, (user_id, "approved", "denied"))
        expenses = cur.fetchall()
        column_names = [description[0] for description in cur.description]
    df = pd.DataFrame(expenses, columns=column_names)
    return df

def edit_expense(expense_id, amount=None, description=None, date=None):
    if amount is None or description is None or date is None:
        with sql.connect(db) as conn:
            df = pd.read_sql("SELECT * FROM expenses WHERE id = ?;", conn, params=(expense_id,))
    if amount is None:
        amount = df.loc[0, 'amount']
    if description is None:
        description = df.loc[0, 'description']
    if date is None:
        date = df.loc[0, 'date']
    query = "UPDATE expenses SET amount = ?, description = ?, date = ? WHERE id = ?;"
    with sql.connect(db) as conn:
        cur = conn.cursor()
        cur.execute(query, (amount, description, date, expense_id))
        conn.commit()

def delete_expense(expense_id):
    query = "DELETE FROM expenses WHERE id = ?"
    with sql.connect(db) as conn:
        cur = conn.cursor()
        cur.execute(query, (expense_id, ))
        query = "DELETE FROM approvals WHERE expense_id = ?"
        cur.execute(query, (expense_id, ))
        conn.commit()

def get_db():
    with sql.connect(db) as conn:
        df_users = pd.read_sql("SELECT * FROM users", conn)
        df_expenses = pd.read_sql("SELECT * FROM expenses", conn)
        df_approvals = pd.read_sql("SELECT * FROM approvals", conn)
    return df_users, df_expenses, df_approvals