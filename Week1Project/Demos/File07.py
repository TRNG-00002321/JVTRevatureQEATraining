# Reading in chunks: useful for large files

with open("example.txt", "r") as file:
    while chunk := file.read(1024): # Read 1024 characters
        print(chunk)