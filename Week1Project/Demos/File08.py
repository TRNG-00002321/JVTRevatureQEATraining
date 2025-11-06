import os

# Specify a path as the first parameter below
path = os.path.join("example.txt")
with open(path) as file:
    print(file.read())