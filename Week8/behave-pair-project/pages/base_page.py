"""
Base Page Object - implement together
"""
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as ec


class BasePage:
    BASE_URL = "https://the-internet.herokuapp.com"

    def __init__(self, driver):
        self.driver = driver
        self.wait = WebDriverWait(driver, 10)

    def navigate_to(self, path):
        """Navigate to a path relative to base URL."""
        self.driver.get(self.BASE_URL + path)

    def wait_for_element(self, locator):
        """Wait for element to be visible."""
        return self.wait.until(ec.visibility_of_element_located(locator))

    def click(self, locator):
        """Click on element after waiting for it."""
        element = self.wait_for_element(locator)
        element.click()

    def type_text(self, locator, text):
        """Type text into element after clearing it."""
        element = self.wait_for_element(locator)
        element.clear()
        element.send_keys(text)

    def get_text(self, locator):
        """Get text from element."""
        element = self.wait_for_element(locator)
        return element.text

    def is_displayed(self, locator):
        """Check if element is displayed."""
        element = self.wait_for_element(locator)
        return element.is_displayed()