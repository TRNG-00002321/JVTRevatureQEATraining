# Originally created: 11/06/2025
# Version: 1.0.1

# Create a list of 5 numbers. Calculate and print their squares.
nums = [13, 5, 6, 9, 12]
# Demonstrates the map() function,
# which can be used to solve this problem instead of your typical loop solution
squares =list(map(lambda x: x**2, nums))
print(squares)

# Another ex: converting a list of names into proper case
names = ['john', 'mIKE', 'LOUIS', 'kImbERly']
names_formatted = list(map(lambda x: x.capitalize(), names))
print(names_formatted)

# filter() demo
# Create another list of numbers. From that list, create a list containing only even numbers.
nums_more = [19, 27, 33, 62, 70, 128, 10, 61]
even_nums = list(filter(lambda x: x % 2 == 0, nums_more))
print(even_nums)

# Given a list of numbers from 1 through 10. Display the sum of numbers.
nums2 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
print(sum(nums2))

# reduce() demo
# Applies a function of two args cumulatively to items of an iterable from left to right,
# reducing the iterable to a single value.
from functools import reduce
nums3 = [1, 2, 3, 4]
product = reduce(lambda x, y: x*y, nums3)
print(product)

# zip() demo + unzipping
# Define two lists, the first one containing names and the second list containing the ages.
# Combine those two lists into tuples.
names2 = ["Alice", "Bob", "Charlie", "David"]
ages2 = [30, 24, 35, 19]
combined_nameAges = list(zip(names2, ages2))
print(combined_nameAges)
unzipped_names, unzipped_ages = map(lambda x: list(x), zip(*combined_nameAges))
print(unzipped_names)
print(unzipped_ages)