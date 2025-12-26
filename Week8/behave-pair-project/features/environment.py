"""
Behave Environment Hooks
"""
from behave import use_step_matcher
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

from pages.form_page import FormPage
from pages.login_page import LoginPage
from pages.base_page import BasePage

use_step_matcher('parse')

def before_all(context):
    """
    Setup before all tests.
    Configure browser options, logging, etc.
    """
    # TODO: Implement together
    # Set up any global configuration
    pass


def before_scenario(context, scenario):
    """
    Setup before each scenario.
    Initialize WebDriver and page objects.
    """
    # 1. Set up WebDriver
    # 2. Initialize page objects on context
    # 3. Configure implicit wait

    service = Service(ChromeDriverManager().install())
    context.driver = webdriver.Chrome(service=service)
    context.driver.implicitly_wait(1)
    context.driver.maximize_window()

    # Initialize page objects
    context.login_page = LoginPage(context.driver)
    context.form_page = FormPage(context.driver)
    context.base_page = BasePage(context.driver)


def after_scenario(context, scenario):
    """
    Cleanup after each scenario.
    Take screenshot on failure, quit browser.
    """
    # 1. Check if scenario failed
    # 2. If failed, take screenshot
    # 3. Attach to report
    # 4. Quit driver

    if scenario.status == 'failed':
        # Take screenshot
        screenshot = context.driver.get_screenshot_as_png()
        scenario.attach(screenshot, mime_type='image/png')

    if hasattr(context, 'driver'):
        context.driver.quit()


def after_all(context):
    """
    Cleanup after all tests.
    """
    # TODO: Any final cleanup
    pass