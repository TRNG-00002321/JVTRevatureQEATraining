# 3. Given a number n, find the first digit of the number.

def find_first_digit(num):
    return str(num)[0]

n = float(input("Enter a number: "))

print(find_first_digit(n))