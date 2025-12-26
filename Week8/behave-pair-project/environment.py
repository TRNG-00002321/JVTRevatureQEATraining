from behave import use_step_matcher
use_step_matcher('parse')

def before_all(context):
    """Runs once before all features"""
    # Add global configuration
    context.config.base_url = "https://the-internet.herokuapp.com"
    context.config.timeout = 10


def before_scenario(context, scenario):
    """Runs before each scenario"""
    # Initialize browser
    from selenium import webdriver
    context.browser = webdriver.Chrome()

    # Initialize page objects
    # TODO

    # Initialize test data store
    context.test_data = {}


def after_scenario(context, scenario):
    """Runs after each scenario"""
    if hasattr(context, 'browser'):
        context.browser.quit()