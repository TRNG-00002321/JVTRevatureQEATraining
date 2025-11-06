# Originally created: 11/06/2025
# Version: 1.0.0

# <strong>Coding Assignment</strong>
# <strong></strong>
# <strong>If, Else, and Elif Problems:</strong>
#
# For this problem you are going to make a program that simulates the output of a vending machine that only takes in
# coins of American currency.
# 1.Your program should take an integer as an input from the user (either a 1, 2, or 3) that corresponds with an option
# for a drink from the vending machine outlined below and assign the corresponding price to a variable as a float.
# Use your knowledge of if, elif, and else statements to complete this part of the problem. Your code should
# have an else statement that prints a message and ends the program using sys.exit() if the user does not enter a valid
# input number.
# Vending Machine:
# 1.water = $1.00
# 2.cola = $1.50
# 3.gatorade = $2.00
# 2.After placing an order, the user should be prompted to enter inputs 4 times:
# 1.The first time, the user should be prompted to enter the number of quarters they put in the machine. Assign this
# number to a variable as an integer.
# 2.The second time, the user should be prompted to enter the number of dimes they put in the machine. Assign this
# number to a variable as an integer.
# 3.The third time, the user should be prompted to enter the number of nickles they put in the machine. Assign this
# number to a variable as an integer.
# 4.The fourth time, the user should be prompted to enter the number of pennies they put in the machine. Assign this
# number to a variable as an integer.
# 3.Create a variable to hold the total value of all the coins the user has put into the machine.
# 4.Use flow control statements to print the user's change or output a message asking the user to try again depending
# on whether the total value of the coins the user has put into the machine is enough to pay for the item they ordered.
# New knowledge for this problem:
# 1.%f format specifier
# 2.import sys and sys.exit()
# 3.int()

import sys

def add_coins(quarters=0, dimes=0, nickels=0, pennies=0):
    return quarters * 0.25 + dimes * 0.10 + nickels * 0.05 + pennies * 0.01

def insert_coins():
    num_quarters = int(input("Enter a number of quarters: "))
    num_dimes = int(input("Enter a number of dimes: "))
    num_nickels = int(input("Enter a number of nickels: "))
    num_pennies = int(input("Enter a number of pennies: "))
    total = add_coins(num_quarters, num_dimes, num_nickels, num_pennies)
    return total

user_option = int(input("Enter a vending option (1, 2, or 3): "))
name = ""
cost = 0.0
change = 0.0

if user_option == 1:
    name = "water"
    cost = 1.0
elif user_option == 2:
    name = "cola"
    cost = 1.5
elif user_option == 3:
    name = "gatorade"
    cost = 2.0
else:
    print("Invalid input number")
    sys.exit("Invalid input number")

# alt implementation for user_option input reading
# match user_option:
    # case 1:
        # name = "water"
        # cost = 1.0
    # case 2:
        # name = "cola"
        # cost = 1.5
    # case 3:
        # name = "gatorade"
        # cost = 2.0
    # case _:
        # print("Invalid input number")
        # sys.exit("Invalid input number")

user_money = insert_coins()
change = user_money - cost

while change < 0:
    print(f"Insufficient money, need ${(cost - user_money):.2f} more to buy {name}.")
    added = insert_coins()
    user_money += added
    change = user_money - cost

print(f"{name} purchased.")
print(f"Change: ${change:.2f}")