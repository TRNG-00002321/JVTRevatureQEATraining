import unittest
import sys
from src.Calculator import Calculator

class TestCalculator(unittest.TestCase):
    def setUp(self):
        self.calculator = Calculator()

    def tearDown(self):
        self.calculator = None

    def test_add(self):
        # Arrange
        n1 = 1
        n2 = 2
        expected = 3

        # Act
        result = self.calculator.add(n1, n2)

        # Assert
        self.assertEqual(result, expected)

    def test_divide_by_zero(self):
        with self.assertRaises(ZeroDivisionError):
            self.calculator.divide(1, 0)

    def test_divide_by_zero_context(self):
        with self.assertRaises(ZeroDivisionError) as context:
            self.calculator.divide(1, 0)
        self.assertEqual(str(context.exception), "Cannot divide by zero")

    @unittest.skip("Demonstrating unconditional skipping")
    def test_unconditional_skip(self):
        self.fail("This test should not run")

    @unittest.skipIf(sys.platform == 'win32', "Skipping on Windows")
    def test_linux_only_feature(self):
        self.assertTrue(True)  # This test runs only on non-Windows platforms

    # @unittest.skipUnless(hasattr(self, 'resource_available'), "Resource not available")
    # def test_requires_resource(self):
        # self.assertTrue(True)  # This test runs only if 'resource_available' exists

    # def test_dynamic_skip(self):
    #             if not some_condition_is_met():
    #                 self.skipTest("Condition not met for this test")
    #             self.assertTrue(True)

    @unittest.expectedFailure
    def test_known_bug(self):
        self.assertEqual(1, 2, "This test is expected to fail due to a known bug")

    #