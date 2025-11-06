# 3. Given a string s, and a pattern p.
# You need to find if p exists in s or not and return the starting index of p in s.
# If p does not exist in s then -1 will be returned.
# Here p and s both are case-sensitive.

def custom_find(main_string, sub_string, start=0, end=None):
    if end is None:
        end = len(main_string)

    # Ensure the substring is not longer than the search area
    if len(sub_string) > (end - start):
        return -1

    for i in range(start, end - len(sub_string) + 1):
        if main_string[i:i + len(sub_string)] == sub_string:
            return i
    return -1

s = input("Enter a string: ")
p = input("Enter a pattern: ")

print(custom_find(s, p))

# alt solution:
# print(s.find(p))