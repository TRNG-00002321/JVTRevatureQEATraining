# Create a list of strings containing 5 elements.
# Based on this list, create another list having elements from the previous list containing the character "a".

string_list = ["123", "abc", "DEF", "long", "Man"]

a_list = [item for item in string_list if item.find("a") > -1]

print(a_list)