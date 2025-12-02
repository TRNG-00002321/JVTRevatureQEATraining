# Originally created: 11/13/2025
# Version: 1.0.0

import sqlite3 as sql
import pandas as pd
from sqlalchemy import create_engine, MetaData

db = "../expenses_database.db"
engine = create_engine("mysql+mysqlconnector://root:password@localhost:3306/expensesystem")
metadata = MetaData()
metadata.reflect(bind=engine)
users_table = metadata.tables["users"]
expenses_table = metadata.tables["expenses"]
approvals_table = metadata.tables["approvals"]

def verify_user(username, password):
    query = "SELECT * FROM users WHERE username = %s AND password = %s"
    df = pd.read_sql(query, con=engine, params=(username, password))
    if df.empty:
        return None
    else:
        return df

def submit_expense(user_id, amount, description, date):
    query = "INSERT INTO expenses(user_id, amount, description, date) VALUES(?, ?, ?, ?);"
    with sql.connect(db) as conn:
        cur = conn.cursor()
        cur.execute(query, (int(user_id), float(amount), description, date))
        conn.commit()

        if cur.lastrowid is not None:
            expense_id = cur.lastrowid
            query = "INSERT INTO approvals(expense_id, status) VALUES(?, ?);"
            cur.execute(query, (int(expense_id), "pending"))
            conn.commit()
        else:
            print("Error when inserting expense: cur.lastrowid is None")

def view_expenses_statuses(user_id):
    query = """SELECT e.id, e.user_id, e.amount, e.description, e.date, a.status, a.comment 
        FROM expenses AS e 
        JOIN approvals AS a ON e.id = a.expense_id
        WHERE user_id = %s;
        """
    df = pd.read_sql(query, con=engine, params=(int(user_id),))
    return df

def view_expenses_pending(user_id):
    query = """SELECT e.id, e.amount, e.description, e.date 
        FROM expenses AS e 
        JOIN approvals AS a ON e.id = a.expense_id 
        WHERE e.user_id = %s AND a.status = %s;
        """
    df = pd.read_sql(query, con=engine, params=(int(user_id), "pending"))
    return df

def view_expenses_history(user_id):
    query = """SELECT e.id, e.amount, e.description, e.date, a.status, a.comment 
        FROM expenses AS e 
        JOIN approvals AS a ON e.id = a.expense_id 
        WHERE e.user_id = %s AND (a.status = %s OR a.status = %s);
        """
    df = pd.read_sql(query, con=engine, params=(int(user_id), "approved", "denied"))
    return df

def edit_expense(expense_id, amount=None, description=None, date=None):
    df = pd.read_sql("SELECT * FROM expenses WHERE id = %s;", con=engine, params=(int(expense_id),))
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
    df_users = pd.read_sql_table("users", con=engine)
    df_expenses = pd.read_sql_table("expenses", con=engine)
    df_approvals = pd.read_sql_table("approvals", con=engine)
    return df_users, df_expenses, df_approvals