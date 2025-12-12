import pytest

from src import odometer

def test_odometer_normal(monkeypatch):
    monkeypatch.setattr(odometer, 'speed', lambda: 70)
    assert odometer.alert() is False

def test_odometer_low(monkeypatch):
    monkeypatch.setattr(odometer, 'speed', lambda: 5)
    assert odometer.alert() is True

def test_odometer_high(monkeypatch):
    monkeypatch.setattr(odometer, 'speed', lambda: 200)
    assert odometer.alert() is True

def test_odometer_bound_low(monkeypatch):
    monkeypatch.setattr(odometer, 'speed', lambda: 60)
    assert odometer.alert() is False

def test_odometer_bound_high(monkeypatch):
    monkeypatch.setattr(odometer, 'speed', lambda: 120)
    assert odometer.alert() is False