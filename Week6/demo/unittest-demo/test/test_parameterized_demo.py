import pytest

@pytest.mark.parametrize("input_value, expected_output", [
    (1, 2),
    (2, 4),
    (3, 6),
])
def test_double(input_value, expected_output):
    assert input_value * 2 == expected_output

# Assume you have a function to test, for example:
def add(a, b):
    return a + b

# Parameterized test for the 'add' function
@pytest.mark.parametrize(
    "num1, num2, expected_sum",  # Names of the parameters to be passed to the test function
    [
        (1, 2, 3),        # Test case 1: num1=1, num2=2, expected_sum=3
        (0, 0, 0),        # Test case 2: num1=0, num2=0, expected_sum=0
        (-1, 5, 2),       # Test case 3: num1=-1, num2=5, expected_sum=4
        (10, -3, 7),      # Test case 4: num1=10, num2=-3, expected_sum=7
        (2.5, 3.5, 6.0),  # Test case 5: num1=2.5, num2=3.5, expected_sum=6.0
    ]
)
def test_add_function(num1, num2, expected_sum):
    """
    Tests the 'add' function with various inputs.
    """
    result = add(num1, num2)
    assert result == expected_sum