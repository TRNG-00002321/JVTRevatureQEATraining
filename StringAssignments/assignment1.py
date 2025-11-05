# 1. Given two inputs that are stored in variables a and n,
# you need to print a, n times in a single line without space between them.
# Output must have a newline at the end.

def print_input(input, num):
    for i in range(num):
        print(input, end="")
    print()

    # alt solution:
    # print(str(input) * int(num))

a = "a"
n = 5
print_input(a, n)
