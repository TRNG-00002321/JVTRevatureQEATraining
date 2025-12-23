"""
Multi-browser driver factory with webdriver-manager.

Supports:
- Chrome
- Firefox
- Edge
"""

from contextlib import contextmanager
from selenium import webdriver
from selenium.webdriver.chrome.service import Service as ChromeService
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.edge.service import Service as EdgeService
from selenium.webdriver.chrome.options import Options as ChromeOptions
from selenium.webdriver.firefox.options import Options as FirefoxOptions
from selenium.webdriver.edge.options import Options as EdgeOptions
from webdriver_manager.chrome import ChromeDriverManager
from webdriver_manager.firefox import GeckoDriverManager
from webdriver_manager.microsoft import EdgeChromiumDriverManager


@contextmanager
def create_driver(browser: str = "chrome", headless: bool = False):
    """
    Create a WebDriver instance for the specified browser.

    Args:
        browser: Browser name ("chrome", "firefox", "edge")
        headless: Run in headless mode if True

    Yields:
        WebDriver instance

    Example:
        with create_driver("firefox", headless=True) as driver:
            driver.get("https://example.com")
    """
    driver = None

    try:
        if browser.lower() == "chrome":
            # TODO: Implement Chrome driver setup
            # 1. Create ChromeOptions
            # 2. Add headless argument if needed
            # 3. Use ChromeDriverManager for automatic driver download
            options = ChromeOptions()

            options.add_argument("--headless=new")
            options.add_argument("--window-size=1920,1080")
            options.add_argument("--no-sandbox")  # Required for Docker/CI
            options.add_argument("--disable-dev-shm-usage")  # Overcome limited resources
            options.add_argument("--disable-gpu")  # Disable GPU hardware acceleration
            options.add_argument("--disable-extensions")  # Disable extensions
            options.add_argument("--incognito")  # Incognito mode
            options.add_argument("--disable-popup-blocking")  # Allow popups
            options.add_argument("--disable-images")  # Don't load images
            options.add_argument("--blink-settings=imagesEnabled=false")

            service = ChromeService(ChromeDriverManager().install())
            driver = webdriver.Chrome(service=service, options=options)

        elif browser.lower() == "firefox":
            # TODO: Implement Firefox driver setup
            # 1. Create FirefoxOptions
            # 2. Add headless argument if needed (note: Firefox uses -headless)
            # 3. Use GeckoDriverManager
            options = FirefoxOptions()

            options.add_argument("-headless")
            options.add_argument("--width=1920")
            options.add_argument("--height=1080")
            options.add_argument('--hide-scrollbars')
            options.add_argument("--window-size=1920,1080")
            options.add_argument("--no-sandbox")  # Required for Docker/CI
            options.add_argument("--disable-dev-shm-usage")  # Overcome limited resources
            options.add_argument("--disable-gpu")  # Disable GPU hardware acceleration
            options.add_argument("--disable-extensions")  # Disable extensions
            options.add_argument("--incognito")  # Incognito mode
            options.add_argument("--disable-popup-blocking")  # Allow popups
            options.add_argument("--disable-images")  # Don't load images
            options.add_argument("--blink-settings=imagesEnabled=false")

            service = FirefoxService(GeckoDriverManager().install())
            driver = webdriver.Firefox(service=service, options=options)

        elif browser.lower() == "edge":
            # TODO: Implement Edge driver setup
            # 1. Create EdgeOptions
            # 2. Add headless argument if needed
            # 3. Use EdgeChromiumDriverManager
            options = EdgeOptions()

            options.add_argument("--headless=new")
            options.add_argument("--disable-gpu")
            options.add_argument("--window-size=1920,1080")
            options.add_argument("--no-sandbox")  # Required for Docker/CI
            options.add_argument("--disable-dev-shm-usage")  # Overcome limited resources
            options.add_argument("--disable-gpu")  # Disable GPU hardware acceleration
            options.add_argument("--disable-extensions")  # Disable extensions
            options.add_argument("--incognito")  # Incognito mode
            options.add_argument("--disable-popup-blocking")  # Allow popups
            options.add_argument("--disable-images")  # Don't load images
            options.add_argument("--blink-settings=imagesEnabled=false")

            service = EdgeService(EdgeChromiumDriverManager().install())
            driver = webdriver.Edge(service=service, options=options)

        else:
            raise ValueError(f"Unsupported browser: {browser}")

        driver.implicitly_wait(10)
        yield driver

    finally:
        if driver:
            driver.quit()


def get_browser_version(browser: str) -> str:
    """
    Get the installed browser version.

    TODO: Implement version detection for each browser
    """
    # YOUR CODE HERE
    pass