name = "Alice"
score = 95

with open("report.txt", "w") as file:
    file.write(f"Student: {name}\nScore: {score}\n")