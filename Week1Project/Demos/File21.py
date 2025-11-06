import json

my_data = {
    "name" : "Alice",
    "age": 30,
    "city": "New York",
    "isStudent": False,
    "courses": ["Math", "Science"]
}

with open("data.json", "w") as f:
    json.dump(my_data, f, indent=4)