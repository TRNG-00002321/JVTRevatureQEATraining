# Originally created: 11/07/2025
# Version: 1.0.2

import logging
import json

# To-Do List Manager: Create a program to add, view, mark as complete, and delete tasks from a list/dictionary,
# potentially saving the list/dictionary to a file.
# Please use the following as well while writing code:
# 1. Functions
# 2. Modules (Optional)
# 3. Imports (Optional)
logging.basicConfig(level=logging.INFO)

# A task shall have the following attributes:
# 1. description (string)
# 2. isComplete (bool)
def get_task_list(json_file_name):
    try:
        with open(json_file_name, 'r') as file:
            tasks = json.load(file)
    except FileNotFoundError:
        # If the file doesn't exist, start with an empty list
        logging.log(level=logging.WARNING, msg=f"Warning: '{json_file_name}' not found. Starting with an empty list.")
        tasks = []
    except json.JSONDecodeError:
        # Handle cases where the file might be empty or malformed
        logging.log(level=logging.WARNING, msg=f"Warning: '{json_file_name}' is not a valid JSON or is empty. Starting with an empty list.")
        tasks = []
    return tasks

def save_task_list(json_file_name, tasks):
    with open(json_file_name, "w") as file:
        json.dump(tasks, file, indent=4)

def add_task(task_list, task_description, task_completion):
    new_task = {
        "description": task_description,
        "isComplete": task_completion
    }
    task_list.append(new_task)

def view_tasks(task_list):
    header_string = "===Tasks==="
    print(header_string)
    completion_map = {
        True: "Completed",
        False: "Not Completed"
    }
    for task in task_list:
        print(f"{task['description']}: {completion_map.get(task['isComplete'])}")
    print("=" * len(header_string))

def mark_task(task_list, task_description):
    for task in task_list:
        if task['description'] == task_description:
            if task['isComplete']:
                # print("This task is already completed.")
                pass
            else:
                task['isComplete'] = True
                # print("Marking this task as completed.")

def delete_task(task_list, task_description):
    removed = False
    removed_count = 0

    for task in task_list:
        if task['description'] == task_description:
            task_list.remove(task)
            removed = True
            removed_count += 1

    # if not removed:
        # print("Task not found.")
    # else:
        # print(f"Deleted {removed_count} task{'s' if removed_count > 1 else ""} matching this description.")

    return removed_count

def remove_tasks(task_list):
    removed_count = 0

    for task in task_list:
        if task['isComplete']:
            task_list.remove(task)
            removed_count += 1

    print(f"Deleted {removed_count} task{'s' if removed_count > 1 else ""}.")

# Main program loop:
# 1. Prompt user for action (add task, view task, mark as complete, delete task, quit program)
# 2. Run corresponding function
# 3. Loop until user prompts to quit
# 4. On quit, save the list/dictionary to a file
def main_console_loop():
    # Read any existing list from JSON file
    to_do_list_file = "toDoList.json"
    task_list = get_task_list(to_do_list_file)

    is_user_done = False
    actions = [
        "# ACTIONS:",
        "1. Add a task",
        "2. View tasks",
        "3. Mark a task as complete",
        "4. Delete a task",
        "5. Remove completed tasks",
        "6. Quit program"
    ]
    user_action_map = {
        "1. add task": 1,
        "2. view tasks": 2,
        "3. mark task": 3,
        "4. delete task": 4,
        "5. remove completed tasks": 5,
        "6. quit program": 6,
        "add": 1,
        "view": 2,
        "mark": 3,
        "delete": 4,
        "remove": 5,
        "quit": 6,
        "q": 6,
        "1": 1,
        "2": 2,
        "3": 3,
        "4": 4,
        "5": 5,
        "6": 6,
    }
    bool_input_map = {
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

    while not is_user_done:
        for action in actions:
            print(action)
        user_action = user_action_map.get(input("Choose an action: ").lower())
        print()

        match user_action:
            case 1:
                task_desc = input("Describe the task: ").capitalize()
                current_completion = bool_input_map.get(input("Is this task completed yet (y/n)? ").lower().strip())
                add_task(task_list, task_desc, current_completion)
            case 2:
                view_tasks(task_list)
            case 3:
                task_desc = input("Enter task description: ").capitalize()
                mark_task(task_list, task_desc)
            case 4:
                task_desc = input("Enter task description: ").capitalize()
                delete_task(task_list, task_desc)
            case 5:
                remove_tasks(task_list)
            case 6:
                is_user_done = True
            case _:
                print(f"Error: Invalid action: {user_action}")
        print()

    # Save the list of tasks to JSON file
    save_task_list(to_do_list_file, task_list)