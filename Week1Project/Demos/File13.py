lines = ["Line1\n", "Line2\n", "Line3\n", "Line4\n", "Line5\n"]
with open("multilines.txt", "w") as file:
    file.writelines(lines)