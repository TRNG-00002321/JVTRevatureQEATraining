# Create a program that creates a "Hello World" string
#  and utilizes the common String methods
#  e.g., lower(), upper(), strip(), lstrip(), rstrip(), replace(), split(), join(), find(), index()

string1 = "\t   Hello World \t "

print(f"string1: {string1}")
print(f"string1.lower(): {string1.lower()}")
print(f"string1.upper(): {string1.upper()}")
print(f"string1.strip(\"lw\"): {string1.strip("lw")}")
print(f"string1.lstrip(\"lw\"): {string1.lstrip("lw")}")
print(f"string1.rstrip(\"lw\"): {string1.rstrip("lw")}")
print(f"string1.replace(\"l\",\"p\"): {string1.replace("l","p")}")
string1_splits = string1.split(" ")
print(f"string1.split: {string1_splits}")
print(f"\"_,_\".join(string1_splits): {"_,_".join(string1_splits)}")
print(f"string1.find(\"or\"): {string1.find("or")}")
print(f"string1.index(\"World\"): {string1.index("World")}")