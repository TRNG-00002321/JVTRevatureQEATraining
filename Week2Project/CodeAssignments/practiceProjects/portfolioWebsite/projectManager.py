# Originally created: 11/11/2025
# Version: 1.0.0

import json
import sys

# To create the initial json file for project data, refer to projectData.py

def load_projects(filename):
    try:
        with open(filename) as json_file:
            projects = json.load(json_file)
    except FileNotFoundError:
        sys.exit(f"File \'{json_file} \' not found")
    except json.JSONDecodeError as e:
        sys.exit(f"JSON Decode Error for invalid string: {e}")
    return projects

def save_projects(filename, projects):
    try:
        with open(filename, 'w') as outfile:
            json.dump(projects, outfile, indent=4)
    except json.JSONDecodeError as e:
        sys.exit(f"JSON Decode Error for invalid string: {e}")