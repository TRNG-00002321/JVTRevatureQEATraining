# Originally created: 11/06/2025
# Version: 1.0.0

# 3. Create a nested dictionary of three employees, each with keys for name, age, and salary.
# Write a function to give each employee a 10% raise and print the updated dictionary.
employees = {
    "emp1":{"name": "Judy", "age": 28, "salary": 55000},
    "emp2":{"name": "James", "age": 64, "salary": 100000},
    "emp3":{"name": "Mary", "age": 37, "salary": 90000}
}

def raise_salaries(dictionary):
    for employee_key, employee_info in dictionary.items():
        for employee_info_key, employee_info_value in employee_info.items():
            if employee_info_key == "salary":
                dictionary[employee_key]["salary"] *= 1.1
    print(dictionary)

raise_salaries(employees)