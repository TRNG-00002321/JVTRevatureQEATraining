# Originally created: 11/06/2025
# Version: 1.0.0

import json

# Take input from user. Store input data in a dictionary then write it into a file, appending each time.
json_file_name = "dictionary.json"
try:
    with open(json_file_name, 'r') as file:
        data = json.load(file)
except FileNotFoundError:
    # If the file doesn't exist, start with an empty list
    data = []
except json.JSONDecodeError:
    # Handle cases where the file might be empty or malformed
    print(f"Warning: '{json_file_name}' is not a valid JSON or is empty. Starting with an empty list.")
    data = []

user_name = input("Enter a name: ").capitalize()
user_age = int(input("Enter a age: "))
user_city = input("Enter a city: ")
isStudent_map = {
        "true": True,
        "false": False,
        "t": True,
        "f": False,
        "yes": True,
        "no": False,
        "y": True,
        "n": False,
        "1": True,
        "0": False
}
user_isStudent = isStudent_map.get(input(f"Is {user_name} a student (y/n)? ").lower())
user_courses = list(input("Enter course(s): ").strip().split(", "))

person = {
    "name": user_name,
    "age": user_age,
    "city": user_city,
    "isStudent": user_isStudent,
    "courses": user_courses
}
data.append(person)

with open(json_file_name, "w") as file:
    json.dump(data, file, indent=4)