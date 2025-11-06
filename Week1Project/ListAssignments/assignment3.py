# 3. You are given a list arr that contains integers.
# You need to return average of the non-negative integers.
# Examples:
# Input: arr = [-12, 8, -7, 6, 12, -9, 14]
# Output: avg = 10.0
# Explanation: The non-negative numbers are 8 6 12 14. The sum is 8+6+12+14 = 40, Average = 40/4 = 10.0

def average(ints):
    sum = 0
    count = 0

    for i in ints:
        if i > 0:
            sum += i
            count += 1

    return sum/count

arr = [-12, 8, -7, 6, 12, -9, 14]

print(f"avg = {average(arr)}")