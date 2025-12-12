import pytest
from src import total

def test_calculate_total(mocker):
    mocker.patch('src.total.read', side_effect=[[1, 2, 3]])
    assert total.calculate_total('') == 6

def test_multiply_values(mocker):
    def multiply_values(values):
        result = 1
        for v in values:
            result *= v
        return result

    mocker.patch('src.total.read', side_effect=[[1, 2, 3, 4]])
    mocker.patch('src.total.sum', side_effect=multiply_values)
    assert total.calculate_total('') == 24

def test_calculate_total_negative(mocker):
    def negative_check_side_effect(values):
        if any(v < 0 for v in values):
            raise ValueError("Negative values not allowed")
        return sum(values)

    mocker.patch('src.total.read', side_effect=[[1, 2, -3, 4]])
    mocker.patch('src.total.sum', side_effect=negative_check_side_effect)

    with pytest.raises(ValueError) as context:
        total.calculate_total('')

    assert "Negative values" in str(context.value)
