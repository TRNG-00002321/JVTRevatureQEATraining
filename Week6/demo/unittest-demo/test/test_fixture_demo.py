import pytest

@pytest.fixture
def database_connection():
    # Setup: Establish a database connection
    print("Establishing database connection...")
    connection = "simulated_db_connection" # Replace with actual connection logic
    yield connection # Yield connection to the test
    # Teardown: Close the database connection
    print("Closing database connection...")
    # connection.close() # Replace with actual close logic

def test_database_operation(database_connection):
    print(f"Using database connection: {database_connection}")
    # Perform database operation(s) using the connection
    assert database_connection == "simulated_db_connection"

def test_conftest_user(sample_data):
    assert sample_data["name"] == "Alex"
    assert sample_data["age"] == 22