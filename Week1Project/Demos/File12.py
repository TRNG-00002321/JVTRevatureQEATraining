try:
    with open("newfile.txt", "x") as file:
        file.write("This file was just created.\n")
except FileExistsError:
    print("This file already exists.")