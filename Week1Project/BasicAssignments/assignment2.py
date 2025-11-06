# Basic Problem
# 2. Given three inputs that are stored in the variables a, b, and c.
# You need to print a a times and b b times  in a single line separated by c.

def print_custom(num1, num2, sep):
    for i in range(num1):
        print(f"{num1}", end="")
    print(f"{sep}", end="")
    for i in range(num2):
        print(f"{num2}", end="")

    # alt solution:
    # print(str(num1) * int(num1), end="")
    # print(sep, end="")
    # print(str(num2) * int(num2))

a = int(input("Enter variable a: "))
b = int(input("Enter variable b: "))
c = input("Enter variable c: ")
print_custom(a, b, c)