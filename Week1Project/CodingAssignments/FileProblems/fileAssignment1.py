# Originally created: 11/06/2025
# Version: 1.0.0

# Write a python script to write the contents of one file into another file.
with open("file1.txt", "r") as file:
    data = file.read()

with open("file2.txt", "w") as file:
    file.write(data)