# 1. Given a string s, you need to reverse it.

s = input("Enter a string: ")

for i in range(len(s)):
    print(s[-1 - i], end="")
print()

# alt solutions:
# print("".join(reversed(s)))
# print(s[::-1])