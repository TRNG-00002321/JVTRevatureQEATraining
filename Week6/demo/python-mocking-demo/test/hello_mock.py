from unittest.mock import Mock

# Creating a Mock
weather_api = Mock()

# Configuring the Mock to return a value
weather_api.get_temperature.return_value = 25

# Use a Mock
temp = weather_api.get_temperature('Plano')

# You can assert the other attributes as well

# Verifying / asserting the method was called
weather_api.get_temperature.assert_called_with('Plano')