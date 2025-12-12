import unittest
from unittest.mock import Mock, MagicMock, patch
from src import total

class TestTotal(unittest.TestCase):
    def test_calculate_total(self):
        # total.read = Mock()
        total.read = MagicMock()
        total.read.return_value = [1, 2, 3]
        result = total.calculate_total('')
        self.assertEqual(result, 6)
        total.read.assert_called_once()

    def test_calculate_test_patch(self):
        with patch('src.total.read') as mock_read:
            mock_read.return_value = [2, 3, 4]
            result = total.calculate_total('')
            self.assertEqual(result, 9)

    @patch('src.total.read')
    def test_calculate_total_patch_decorator(self, mock_read_decorator):
        mock_read_decorator.return_value = [2, 3, 4]
        result = total.calculate_total('')
        self.assertEqual(result, 9)
        mock_read_decorator.assert_called_once_with('')

    def multiply_values(self, values):
        result = 1
        for v in values:
            result *= v
        return result

    @patch('src.total.read')
    def test_multiply_values(self, mock_read_decorator):
        mock_read_decorator.return_value = [1, 2, 3, 4]
        with patch('src.total.sum', side_effect=self.multiply_values):
            result = total.calculate_total('')
        self.assertEqual(result, 24)
        mock_read_decorator.assert_called_once_with('')

    # Side effect method for handling negative number(s)
    def negative_check_side_effect(self, values):
        if any(v < 0 for v in values):
            raise ValueError("Negative values not allowed")
        return sum(values)

    @patch('src.total.read')
    def test_calculate_total_negative_patch(self, mock_read_decorator):
        mock_read_decorator.return_value = [2, -3, 4, 5]
        with patch('src.total.sum', side_effect=self.negative_check_side_effect):
            self.assertRaises(ValueError, total.calculate_total, '')
        mock_read_decorator.assert_called_once_with('')