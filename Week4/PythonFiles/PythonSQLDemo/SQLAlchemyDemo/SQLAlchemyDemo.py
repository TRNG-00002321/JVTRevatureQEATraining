from sqlalchemy import *

engine = create_engine('sqlite:///college.db', echo = True)
meta = MetaData()

metadata = MetaData()
users_table = Table('users', metadata,
    Column('id', Integer, primary_key=True),
    Column('name', String),
    Column('email', String))
meta.create_all(engine)

# Example using operators
stmt = select(users_table).where(users_table.c.name == 'Alice')

# Example using and_() for multiple conditions
stmt_complex = select(users_table).where(
    and_(users_table.c.name == 'Bob', users_table.c.email.like('%example.com%')))

# Insert statement
insert_stmt = insert(users_table).values(name='Charlie', email='charlie@example.com')

# Update statement
update_stmt = update(users_table).where(users_table.c.name == 'Alice').values(email='alice_new@example.com')

# Delete statement
delete_stmt = delete(users_table).where(users_table.c.name == 'Bob')

# Execute the statement and fetch results
stmt = select(users_table)
with engine.connect() as connection:
     result = connection.execute(stmt)
     for row in result:
         print(row)

# stmt = text("SELECT * FROM students WHERE students.name BETWEEN :x AND :y")
#
# stmt = stmt.bindparams(
#    bindparam("x", type_= String),
#    bindparam("y", type_= String)
# )
#
# result = conn.execute(stmt, {"x": "A", "y": "L"})

# Create an alias for the 'users' table
# u_alias = users.alias("u")

# Use the alias in a select statement
# s = select(u_alias.c.name).where(u_alias.c.id > 5)

# Using the UPDATE expression
# stmt = students.update().where(students.c.lastname == 'Khanna').values(lastname = 'Kapoor')

# Using the DELETE expression
# stmt = students.delete().where(students.c.id > 2)