# Originally created: 11/06/2025
# Version: 1.0.0

# Map Assignment
# 1. Convert Celsius to Fahrenheit: Given a list of temperatures in Celsius, use map() to convert them to Fahrenheit.
# The formula is F = (C * 9/5) + 32.
# Example
#     celsius_temps = [0, 10, 20, 30]
#     # Expected output: [32.0, 50.0, 68.0, 86.0]
celsius_temps = [0, 10, 20, 30]
fahrenheit_temps = list(map(lambda x: (x * 1.8) + 32, celsius_temps))
print(f"1. Convert Celsius to Fahrenheit: {fahrenheit_temps}")

# 2. Capitalize a List of Names: Given a list of names, use map() to return a new list where each name is capitalized.
# Example
#     names = ["alice", "bob", "charlie"]
#     # Expected output: ["Alice", "Bob", "Charlie"]
names2 = ["alice", "bob", "charlie"]
names2_capitalized = list(map(lambda x: x.capitalize(), names2))
print(f"2. Capitalize a list of names: {names2_capitalized}")

# 3. Add Corresponding Elements: Given two lists of numbers of the same length,
# use map() to return a new list containing the sum of corresponding elements.
# Example
# 	list1 = [1, 2, 3]
#     list2 = [4, 5, 6]
#     # Expected output: [5, 7, 9]
list1 = [1, 2, 3]
list2 = [4, 5, 6]
sum_list = list(map(lambda x, y: x + y, list1, list2))
print(f"3. Add Corresponding Elements: {sum_list}")

# 4. Concatenate Strings: Given two lists of strings, use map() to concatenate
# corresponding elements with a space in between.
# Example
#     first_names = ["John", "Jane"]
#     last_names = ["Doe", "Smith"]
#     # Expected output: ["John Doe", "Jane Smith"]
first_names = ["John", "Jane"]
last_names = ["Doe", "Smith"]
full_names = list(map(lambda x, y: x + " " + y, first_names, last_names))
print(f"4. Concatenate Strings: {full_names}")

# 5. Apply a Custom Function: Define a function that takes a string and returns its length.
# Then, use map() to apply this function to a list of strings, returning a list of lengths.
# Example
#     words = ["apple", "banana", "cherry"]
#     # Expected output: [5, 6, 6]
words = ["apple", "banana", "cherry"]

def get_length(string):
    return len(string)

lengths = list(map(get_length, words))
# lengths = list(map(lambda x: len(x), words))
print(f"5. Applying a custom function (return a list of lengths): {lengths}")
