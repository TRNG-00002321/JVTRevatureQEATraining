"""
TODO: Implement a driver factory that:
1. Uses webdriver-manager for automatic driver management
2. Provides a context manager for safe browser cleanup
3. Supports headless mode via parameter
"""

from contextlib import contextmanager
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

@contextmanager
def create_chrome_driver(headless: bool = False):
    # YOUR CODE HERE
    # 1. Create ChromeOptions and configure headless if needed
    # 2. Set up Service with ChromeDriverManager
    # 3. Create driver, yield it, and ensure quit() in finally block
    pass