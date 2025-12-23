"""
DONE: Implement a driver factory that:
1. Uses webdriver-manager for automatic driver management
2. Provides a context manager for safe browser cleanup
3. Supports headless mode via parameter
"""

from contextlib import contextmanager
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

@contextmanager
def create_chrome_driver(headless: bool = False):
    # 1. Create ChromeOptions and configure headless if needed
    # 2. Set up Service with ChromeDriverManager
    # 3. Create driver, yield it, and ensure quit() in finally block
    options = Options()

    # Adding arguments
    if headless:
        # New headless mode (Chrome 109+)
        options.add_argument("--headless=new")

        # Required for stability in headless mode
        options.add_argument("--no-sandbox")
        options.add_argument("--disable-dev-shm-usage")

        # Set window size (important for headless - no auto-maximize)
        options.add_argument("--window-size=1920,1080")
    else:
        options.add_argument("--start-maximized")

    # Stability arguments (recommended for automation)
    options.add_argument("--no-sandbox")  # Required for Docker/CI
    options.add_argument("--disable-dev-shm-usage")  # Overcome limited resources
    options.add_argument("--disable-gpu")  # Disable GPU hardware acceleration
    options.add_argument("--disable-extensions")  # Disable extensions

    # Security/Privacy arguments
    options.add_argument("--incognito")  # Incognito mode
    options.add_argument("--disable-popup-blocking")  # Allow popups

    # Performance arguments
    options.add_argument("--disable-images")  # Don't load images
    options.add_argument("--blink-settings=imagesEnabled=false")

    service = Service(ChromeDriverManager().install())
    driver = webdriver.Chrome(service=service, options=options)

    try:
        yield driver
    finally:
        driver.quit()