# Originally created: 11/12/2025
# Version: 1.0.1
# The purpose of this script is to create the database for this project
# if it does not yet exist and then create the corresponding tables,
# as specified by P0.md. Some sample values shall also be created and
# inserted into the database.

import sqlite3 as sqlite
import pandas as pd
import mysql.connector as mysql
from sqlalchemy import create_engine

db = "expenses_database.db"
engine = create_engine("mysql+mysqlconnector://root:password@localhost:3306/expensesystem")

def create_tables():
    try:
        # Creates the sqlite database file if it does not exist.
        with sqlite.connect(db) as sqlite_conn:
            sqlite_cur = sqlite_conn.cursor()
            sqlite_script = """
                CREATE TABLE IF NOT EXISTS users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    username TEXT UNIQUE NOT NULL,
                    password TEXT NOT NULL,
                    role TEXT NOT NULL
                );
                CREATE TABLE IF NOT EXISTS expenses (
                    id INTEGER PRIMARY KEY AUTOINCREMENT, 
                    user_id INTEGER NOT NULL, 
                    amount REAL NOT NULL,  
                    description TEXT NOT NULL,
                    date TEXT NOT NULL,
                    FOREIGN KEY (user_id) REFERENCES users (id)
                );
                CREATE TABLE IF NOT EXISTS approvals (
                    id INTEGER PRIMARY KEY AUTOINCREMENT, 
                    expense_id INTEGER NOT NULL,
                    status TEXT NOT NULL,
                    reviewer INTEGER,
                    comment TEXT,
                    review_date TEXT,
                    FOREIGN KEY (expense_id) REFERENCES expenses (id),
                    FOREIGN KEY (reviewer) REFERENCES users (id)
                );
            """
            sqlite_cur.executescript(sqlite_script)
            sqlite_conn.commit()
        with mysql.connect(host="localhost", user="root", password="password", database="expensesystem") as mysql_conn:
            mysql_cur = mysql_conn.cursor()
            mysql_script_users = """
                CREATE TABLE IF NOT EXISTS users (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    username VARCHAR(255) UNIQUE NOT NULL,
                    password VARCHAR(255) NOT NULL,
                    role VARCHAR(255) NOT NULL
                ) 
            """
            mysql_script_expenses = """
                CREATE TABLE IF NOT EXISTS expenses (
                    id INT AUTO_INCREMENT PRIMARY KEY, 
                    user_id INT NOT NULL, 
                    amount DOUBLE NOT NULL,  
                    description VARCHAR(255) NOT NULL,
                    date VARCHAR(10) NOT NULL,
                    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE
                )
            """
            mysql_script_approvals = """
                CREATE TABLE IF NOT EXISTS approvals (
                    id INT AUTO_INCREMENT PRIMARY KEY, 
                    expense_id INT NOT NULL,
                    status VARCHAR(8) NOT NULL,
                    reviewer INT,
                    comment VARCHAR(255),
                    review_date VARCHAR(10),
                    FOREIGN KEY (expense_id) REFERENCES expenses (id) ON DELETE CASCADE ON UPDATE CASCADE,
                    FOREIGN KEY (reviewer) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE
                )
            """
            mysql_cur.execute(mysql_script_users)
            mysql_conn.commit()
            mysql_cur.execute(mysql_script_expenses)
            mysql_conn.commit()
            mysql_cur.execute(mysql_script_approvals)
            mysql_conn.commit()
    except sqlite.Error as e:
        print(f"SQLite Error while creating tables: {e}")
    except mysql.Error as e:
        print(f"MySQL Error while creating tables: {e}")

def insert_samples():
    sample_users = [
        ("Jeff", "password1", "Employee"),
        ("Jane", "password2", "Employee"),
        ("Smith", "password3", "Employee"),
        ("Abagail", "password4", "Manager"),
        ("Terry", "password5", "Manager"),
        ("Pablo", "password6", "Employee"),
        ("Walker", "password7", "Employee"),
        ("Muhammad", "password8", "Manager"),
        ("Bruce", "password9", "Employee"),
        ("Oscar", "password10", "Employee"),
        ("Larry", "password11", "Employee"),
        ("James", "password1", "Manager"),
        ("Susan", "password7", "Manager"),
        ("Adeline", "password123", "Employee"),
        ("Danielle", "password789", "Employee"),
        ("Patricia", "password643", "Employee"),
    ]
    sample_expenses = [
        (1, 19.99, "Lunch", "2024-12-01"),
        (2, 39.52, "Commuting expenses", "2025-01-31"),
        (2, 9.95, "Lunch", "2025-01-14"),
        (16, 109.72, "Brunches for the month", "2025-02-28"),
        (10, 5273.77, "Yearly travel expenses for 2024", "2025-01-10"),
        (13, 346, "Slushies", "2025-10-13"),
        (7, 178.85, "Staplers", "2024-11-30"),
        (9, 500, "Things", "2025-07-03"),
        (6, 213.24, "Miller lite", "2025-06-07"),
        (14, 64.43, "Covering tab for a manager", "2025-08-23"),
        (11, 76.32, "Business-related handkerchief", "2025-05-30")
    ]
    sample_approvals = [
        (6, "pending", 13, "Why are you work-expensing slushies?!?", "2025-10-20"),
        (4, "approved", 4, "Brunches were work-related and professional in nature.", "2025-03-14"),
        (3, "denied", 4, "No.", "2025-01-14"),
        (5, "pending", None, None, None),
        (8, "approved", 5, "Sure, whatever.", "2025-07-10"),
        (9, "denied", 5, "Recreational beer is not a work expense!", "2025-06-10"),
        (11, "pending", None, None, None),
        (2, "approved", 12, "Proper documentation of commuting provided", "2025-02-20"),
        (10, "denied", 13, "The manager referenced in this expense does not exist.", "2025-08-30"),
        (1, "pending", 8, None, None),
        (7, "approved", 4, "Checks out", "2024-12-10")
    ]
    query_insert_users = "INSERT INTO users (username, password, role) VALUES (?, ?, ?);"
    query_insert_expenses = "INSERT INTO expenses (user_id, amount, description, date) VALUES (?, ?, ?, ?);"
    query_insert_approvals = "INSERT INTO approvals (expense_id, status, reviewer, comment, review_date) VALUES (?, ?, ?, ?, ?);"
    try:
        with sqlite.connect(db) as sqlite_conn:
            sqlite_cur = sqlite_conn.cursor()
            sqlite_cur.executemany(query_insert_users, sample_users)
            sqlite_conn.commit()
            sqlite_cur.executemany(query_insert_expenses, sample_expenses)
            sqlite_conn.commit()
            sqlite_cur.executemany(query_insert_approvals, sample_approvals)
            sqlite_conn.commit()
            users_rows = pd.read_sql("SELECT * FROM users", sqlite_conn)
            expenses_rows = pd.read_sql("SELECT * FROM expenses", sqlite_conn)
            approvals_rows = pd.read_sql("SELECT * FROM approvals", sqlite_conn)
        users_rows.to_sql("users", con=engine, index=False, if_exists="append")
        expenses_rows.to_sql("expenses", con=engine, index=False, if_exists="append")
        approvals_rows.to_sql("approvals", con=engine, index=False, if_exists="append")
    except sqlite.Error as e:
        print(f"SQLite Error while inserting: {e}")
    except mysql.Error as e:
        print(f"MySQL Error while inserting: {e}")

if __name__ == "__main__":
    create_tables()
    insert_samples()
    df_users = pd.read_sql_table("users", con=engine)
    df_expenses = pd.read_sql_table("expenses", con=engine)
    df_approvals = pd.read_sql_table("approvals", con=engine)

    # Print results
    pd.set_option("display.max_rows", None)
    pd.set_option("display.max_columns", None)
    pd.set_option("display.max_colwidth", None)
    pd.set_option("display.width", 1000)
    print("users:")
    print(df_users)
    print("\nexpenses:")
    print(df_expenses)
    print("\napprovals:")
    print(df_approvals)