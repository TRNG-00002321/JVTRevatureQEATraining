# 1.Given an array arr[], find the first repeating element.
# The element should occur more than once and the index of its first occurrence should be the smallest.
# Examples:
# Input: arr[] = [1, 5, 3, 4, 3, 5, 6]
# Output: 1
# Explanation: 5 appears twice and its first appearance is at index 1
# which is less than 3 whose first the occurring index is 2.

arr = [1, 5, 3, 4, 3, 5, 6]
first_repeating_index = -1

for i in range(1, len(arr)):
    if arr.count(arr[i]) > 1:
        print(i)
        break
