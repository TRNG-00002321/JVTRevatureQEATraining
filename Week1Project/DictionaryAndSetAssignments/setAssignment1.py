# 1. You are given an array arr[] of size n.
# You have to insert all elements of arr[] into a set and return that set.
# You are also given an integer x.
# If x is found in set then erase it from set and print "erased x", otherwise, print "not found".

# Example arr[] to demonstrate code
arr = [1, 2, 33, 14, 52, 61, 77, 83, 49, 23]
set_arr = set(arr)
x = int(input("Enter an integer: "))

if x in set_arr:
    set_arr.remove(x)
    print("erased x")
    # print(set_arr)
else:
    print("not found")