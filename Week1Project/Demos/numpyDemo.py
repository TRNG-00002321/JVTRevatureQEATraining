import numpy as np

arr1 = np.array([1, 2, 3, 4, 5])
# print(arr1)
# print(type(arr1))
# OUTPUT for above prints
# [1, 2, 3, 4, 5]
# <class 'numpy.ndarray'>

a = np.array(42)
b = np.array([1, 2, 3, 4, 5])
c = np.array([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
d = np.array([[[1, 2, 3], [4, 5, 6]], [[1, 2, 3], [4, 5, 6]]])
# print(a.ndim)
# print(b.ndim)
# print(c.ndim)
# print(d.ndim)

arr2 = np.array([1, 2, 3, 4], ndmin = 5)
# print(arr2)
# print("number of dimensions: ", arr2.ndim)

arr3 = np.array([[[1, 2, 3], [4, 5, 6]], [[7, 8, 9], [10, 11, 12]]])
# print(arr3[0, 1, 2]) # Returns 6

arr4 = np.array([1, 2, 3, 4, 5, 6, 7])
# print(arr4[1:5])
# print(arr4[-3:-1])
# print(arr4[1:5:2])

arr5 = np.array([[1, 2, 3, 4, 5], [6, 7, 8, 9, 10]])
# print(arr5[1, 1:4])

# Reusing arrays from earlier for this ex; copying as comments here for reference
# a = np.array(42)
# b = np.array([1, 2, 3, 4, 5])
# c = np.array([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
# d = np.array([[[1, 2, 3], [4, 5, 6]], [[1, 2, 3], [4, 5, 6]]])
# print(a.shape)
# print(b.shape)
# print(c.shape)
# print(d.shape)

arr6 = np.array([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12])
arr7 = arr6.reshape(4, 3)
# print(arr7)
arr8 = arr6.reshape(2, 3, 2)
# print(arr8)

# Reusing arrays from earlier; copying as comments here for reference
# arr1 = np.array([1, 2, 3, 4, 5])
# for x in arr1:
    # print(x)
# arr3 = np.array([[[1, 2, 3], [4, 5, 6]], [[7, 8, 9], [10, 11, 12]]])
# for x in arr3:
    # for y in x:
        # for z in y:
            # print(z)
# Using np.nditer to iterate on every scalar
# for x in np.nditer(arr3):
    # print(x)
# Using np.nditer to iterate through every scalar element on a 2D array skipping 1 element
# arr5 = np.array([[1, 2, 3, 4, 5], [6, 7, 8, 9, 10]])
# for x in np.nditer(arr5[:, ::2]):
  # print(x) # Outputs 1, 3, 5, 6, 8, & 10

arr9 = np.array([1, 2, 3])
arr10 = np.array([4, 5, 6])
arr11 = np.concatenate((arr9, arr10))
# print(arr11)
arr12 = np.array([[1, 2], [3, 4]])
arr13 = np.array([[5, 6], [7, 8]])
arr14 = np.concatenate((arr12, arr13), axis=1)
# print(arr14)
arr15 = np.stack((arr9, arr10), axis=1)
# print(arr15)
arr16 = np.hstack((arr9, arr10))
# print(arr16)
arr17 = np.vstack((arr9, arr10))
# print(arr17)

arr18 = np.array([1, 2, 3, 4, 5, 6])
arr19 = np.array_split(arr18, 3)
#print(arr19)

arr20 = np.array([1, 2, 3, 4, 5, 4, 4])
x20 = np.where(arr20 == 4)
# print(x20) # Returns a tuple: (array[3, 5, 6],) -> value present at those indexes
arr21 = np.array([6, 7, 8, 9])
x21 = np.where(arr21 == 7)
# print(x21) # Returns a tuple: (array[1]),)
x22 = np.searchsorted(arr21, 7)
# print(x22)
x23 = np.searchsorted(arr21, 7, side='right')
# print(x23)

arr24 = np.array([3, 2, 0, 1])
# print(np.sort(arr24))
arr25 = np.array([[3, 2, 4], [5, 0, 1]])
# print(np.sort(arr25))

# Create an array from the elements on index 0 and 2:
arr26 = np.array([41, 42, 43, 44])
x26 = [True, False, True, False]
new_arr26 = arr26[x26]
# print(new_arr26)
# Create a filter array that will return only values higher than 42:
arr27 = np.array([41, 42, 43, 44])
filter_arr27 = [] # Create an empty list
# Go through each element in arr
for element in arr27:
  # If the element is higher than 42, set the value to True, otherwise False:
  if element > 42:
    filter_arr27.append(True)
  else:
    filter_arr27.append(False)
new_arr27 = arr27[filter_arr27]
# print(filter_arr27)
# print(new_arr27)
# Create a filter array that will return only even elements from the original array:
arr28 = np.array([1, 2, 3, 4, 5, 6, 7])
filter_arr28 = arr28 % 2 == 0
new_arr28 = arr28[filter_arr28]
print(filter_arr28)
print(new_arr28)