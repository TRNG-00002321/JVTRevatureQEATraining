# Originally created: 11/11/2025
# Version: 1.0.0

# This script is intended to create the initial json file for the portfolio.
# This code is intentionally separated from the rest of the code for the project manager
# to improve reusability and maintainability.
# This project data is just some sample data to demonstrate the functionality of the portfolio website.

import json
import sys

project_data = [
    {"name": "Placeholder name 1", "date_started": "01/30/1990", "date_finished": "11/31/1991", "description": "Placeholder text 1"},
    {"name": "Placeholder name 2", "date_started": "02/17/2000", "date_finished": "05/05/2003", "description": "Placeholder text 2"},
    {"name": "Placeholder name 3", "date_started": "07/30/2006", "date_finished": "09/19/2006", "description": "Placeholder text 3"},
    {"name": "Placeholder name 4", "date_started": "09/22/2009", "date_finished": "10/03/2014", "description": "Placeholder text 4"},
    {"name": "Placeholder name 5", "date_started": "08/20/2021", "date_finished": "12/12/2023", "description": "Placeholder text 5"},
    {"name": "Placeholder name 6", "date_started": "mm/dd/yyyy", "date_finished": "mm/dd/yyyy", "description": "Placeholder text 6"}
]
project_json = "projects.json"

try:
    with open(project_json, 'w') as outfile:
        json.dump(project_data, outfile, indent=4)
except json.JSONDecodeError as e:
    sys.exit(f"JSON Decode Error for invalid string: {e}")
