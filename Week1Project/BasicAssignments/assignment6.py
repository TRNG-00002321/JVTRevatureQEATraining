# Write a program to input two numbers. Calculate and display their integer division

value = int(0)

try:
    num1 = int(input("Enter a number: "))
    num2 = int(input("Enter another number: "))
    value = int(num1 / num2)
except ZeroDivisionError:
    print("Division by zero")
except ValueError:
    print("Invalid input")
else:
    print(value)
finally:
    print("End of Program")