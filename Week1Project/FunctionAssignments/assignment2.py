# 2. Here two integers a and b are given.
# The given input and its values are passed as arguments to the function argumentFunction.
# The argumentFunction is responsible to return (a+b). You need to write this function.

def argumentFunction(int1, int2):
    return int1 + int2

a = int(input("Enter first number: "))
b = int(input("Enter second number: "))
print(argumentFunction(a, b))