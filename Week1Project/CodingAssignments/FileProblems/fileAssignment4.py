# Originally created: 11/06/2025
# Version: 1.0.0

import json
import sys

# Read data from file and allow for searching data, returning relevant data.
# Start with name search then can go to any data search.

def search_data(list_of_dicts, key_name, target):
    target_list = []
    for dictionary_e in list_of_dicts:
        if target in dictionary_e[key_name]:
            target_list.append(dictionary_e)
    return target_list

def search_data_for_students(list_of_dicts, target):
    target_list = []
    for dictionary_e in list_of_dicts:
        if target == dictionary_e["isStudent"]:
            target_list.append(dictionary_e)
    return target_list

def print_results(results):
    print(f"Found {len(results)} result{"s" if len(results) > 1 else ""}.")
    print(results)

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
            target_name = input("Enter target name: ").capitalize()
            print_results(search_data(data, "name", target_name))
        case "age":
            target_age = int(input("Enter target age: "))
            print_results(search_data(data, "age", target_age))
        case "city":
            target_city = input("Enter target city: ")
            print_results(search_data(data, "city", target_city))
        case "isstudent" | "student":
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
            target_isStudent = isStudent_map.get(input(f"Are you searching for students (y/n)? ").lower())
            print_results(search_data_for_students(data, target_isStudent))
        case "course" | "courses":
            target_course = input("Enter target course: ").capitalize()
            print_results(search_data(data, "courses", target_course))
        case _:
            print("Error: Invalid search criteria.")