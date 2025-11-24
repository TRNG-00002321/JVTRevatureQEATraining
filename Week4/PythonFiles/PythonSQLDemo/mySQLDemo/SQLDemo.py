import sqlite3
import mysql.connector

# Connect to a database (or create it if it doesn't exist)
try:
    mydb = mysql.connector.connect(
        host="localhost",  # Or the IP address/hostname of your MySQL server
        user="root",
        password="password",
        database="your_database_name"
    )
    print("Connection established successfully!")
except mysql.connector.Error as err:
    print(f"Error connecting to MySQL: {err}")
if 'mydb' in locals() and mydb.is_connected():
    mycursor = mydb.cursor()

if 'mycursor' in locals():
    mycursor.execute("SELECT * FROM your_table_name")

    # Fetch results
    results = mycursor.fetchall()  # or fetchone(), fetchmany()

    for row in results:
        print(row)

if 'mydb' in locals() and mydb.is_connected():
    mydb.commit()
    print(mycursor.rowcount, "record(s) affected.")

if 'mycursor' in locals():
    mycursor.close()
if 'mydb' in locals() and mydb.is_connected():
    mydb.close()
    print("MySQL connection closed.")