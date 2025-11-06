# Originally created: 11/06/2025
# Version: 1.0.0

# 1. Create a dictionary of five countries and their capitals.
# Write a function that takes a country name as input and returns its capital.
country_dict = {
    "United States": "Washington, D.C.",
    "United Kingdom": "London",
    "Russia": "Moscow",
    "Poland": "Warsaw",
    "France": "Paris"
}

def get_capital(country):
    capital = country_dict[country]
    return capital

test_capital = get_capital("United Kingdom")
print(test_capital)