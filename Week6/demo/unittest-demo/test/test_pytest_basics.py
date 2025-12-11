import pytest
from src.Calculator import Calculator

@pytest.fixture
def calculator():
    return Calculator()

def test_calculator(calculator):
    # calculator = Calculator()
    result = calculator.add(1, 2)
    assert result == 3

def test_is_even(calculator):
    # calculator = Calculator()
    assert calculator.is_even(3) is False
    assert not calculator.is_even(5)

def test_divide_by_zero(calculator):
    # calculator = Calculator()
    with pytest.raises(ZeroDivisionError):
        calculator.divide(3, 0)

def test_divide_by_zero_context(calculator):
    # calculator = Calculator()
    with pytest.raises(ZeroDivisionError) as context:
        calculator.divide(3, 0)
        assert "zero" in str(context.value).lower()