from unittest import TestCase
from unittest.mock import Mock

from src import odometer

class TestOdometer(TestCase):
    def test_odometer_normal(self):
        odometer.speed = Mock(return_value=70)
        self.assertFalse(odometer.alert())

    def test_odometer_low(self):
        odometer.speed = Mock(return_value=5)
        self.assertTrue(odometer.alert())

    def test_odometer_high(self):
        odometer.speed = Mock(return_value=200)
        self.assertTrue(odometer.alert())

    def test_odometer_bound_low(self):
        odometer.speed = Mock(return_value=60)
        self.assertFalse(odometer.alert())

    def test_odometer_bound_high(self):
        odometer.speed = Mock(return_value=120)
        self.assertFalse(odometer.alert())