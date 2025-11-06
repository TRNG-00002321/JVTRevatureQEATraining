# Originally created: 11/06/2025
# Version: 1.0.0

# 2. Make a dictionary of student names and their scores.
# Write a function to find the student with the highest score.
student_dict = {
    "John": 85,
    "Susan": 90,
    "Joe": 72,
    "Matt": 93,
    "Kim": 97,
    "Louis": 83,
    "Pablo": 75
}

def find_highest_score(dictionary):
    highest_student = "None"
    highest_score = -1
    for key, value in dictionary.items():
        if value > highest_score:
            highest_score = value
            highest_student = key
    return highest_student

print(find_highest_score(student_dict))