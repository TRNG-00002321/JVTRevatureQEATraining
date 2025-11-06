# Originally created: 11/06/2025
# Version: 1.0.0

import json
import sys

# Read data from file and allow for searching data, returning relevant data.
# Start with name search then can go to any data search.
json_file_name = "dictionary.json"
try:
    with open(json_file_name, 'r') as file:
        data = json.load(file)
except FileNotFoundError:
    # If the file doesn't exist, start with an empty list
    print(f"Warning: File '{json_file_name}' not found.")
    sys.exit()
except json.JSONDecodeError:
    # Handle cases where the file might be empty or malformed
    print(f"Warning: '{json_file_name}' is not a valid JSON or is empty.")
    sys.exit()
else:
    match input("Enter search criteria: ").lower():
        case "name":
            target = input("Enter target name: ").capitalize()
            print(f"{data["name"]}")
        case "age":
            pass
        case "city":
            pass
        case "isstudent" | "student":
            pass
        case "course" | "courses":
            pass
        case _:
            print("Error: Invalid search criteria.")