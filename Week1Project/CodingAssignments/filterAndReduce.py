# Originally created: 11/06/2025
# Version: 1.0.0
from functools import reduce

# Filter and Reduce Assignment

# 1. Filter Strings by Length
# Given a list of strings, use filter() to create a new list containing only the strings with a length greater than 5.
# Example
# words = ["apple", "banana", "cat", "dog", "elephant", "frog"]
words1 = ["apple", "banana", "cat", "dog", "elephant", "frog"]
greater_length = 5
greater_words1 = list(filter(lambda word: len(word) > greater_length, words1))
print(f"Strings of length greater than {greater_length}: {greater_words1}")

# 2. Filter Students by Grade
# Given a list of dictionaries, where each dictionary represents a student with name and grade keys,
# use filter() to extract students with a grade of 90 or higher.
# Example
# students = [
#     {"name": "Alice", "grade": 85},
#     {"name": "Bob", "grade": 92},
#     {"name": "Charlie", "grade": 78},
#     {"name": "David", "grade": 95}
# ]
students2 = [
    {"name": "Alice", "grade": 85},
    {"name": "Bob", "grade": 92},
    {"name": "Charlie", "grade": 78},
    {"name": "David", "grade": 95}
]
grade_filter = 90
filtered_grade_students = list(filter(lambda student: student["grade"] >= grade_filter, students2))
print(f"Students with a grade of {grade_filter} or higher: {filtered_grade_students}")

# 3. Concatenate Strings
# Given a list of strings, concatenate them into a single string using reduce.
# Example :
# 	words = ["Python", "is", "awesome", "!"]
words3 = ["Python", "is", "awesome", "!"]
concatString = reduce(lambda x, y: x + y, words3)
# print(f"words3: {words3}")
print(f"Reduced string: {concatString}")

# 4. Find the Maximum Element
# Given a list of numbers, find the maximum element using reduce.
# Example:
# 	numbers = [10, 3, 25, 7, 18]
numbers4 = [10, 3, 25, 7, 18]
max_element = reduce(lambda x, y: x if x > y else y, numbers4)
print(f"Max element: {max_element}")

# 5. Flatten a List of Lists
# Given a list of lists, flatten it into a single list using reduce.
# Example:
# 	list_of_lists = [[1, 2], [3, 4], [5, 6]]
list_of_lists5 = [[1, 2], [3, 4], [5, 6]]
flattened_list = reduce(lambda x, y: x + y, list_of_lists5)
print(f"Flattened list: {flattened_list}")
