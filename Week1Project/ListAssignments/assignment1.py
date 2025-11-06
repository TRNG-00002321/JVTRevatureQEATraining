# 1.Create a list that contains integers. You need to return the sum of the list.

def sum_of_list(list):
    sum = 0

    for i in list:
        sum += int(i)

    return int(sum)

integer_list = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

print(sum_of_list(integer_list))
# print(sum(integer_list))