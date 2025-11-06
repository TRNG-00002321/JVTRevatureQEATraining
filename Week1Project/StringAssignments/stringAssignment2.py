# 2. Given a string s, you need to check if it is palindrome or not.
# A palindrome is a string that reads the same from front and back.

s = input("Enter a string: ")

isPalindrome = (s == s[::-1])

# print(isPalindrome)