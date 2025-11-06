# Originally created: 11/06/2025
# Version: 1.0.0

# Write a python script to copy the contents of an image to another file.
with open("example.png", "rb") as file:
    binary_data = file.read()

with open("test.png", "wb") as file:
    file.write(binary_data)