"""
Authentication Step Definitions
"""
from behave import given, when, then
from pages.login_page import LoginPage

@given('the user is on the login page')
def step_on_login_page(context):
    """Navigate to login page."""
    context.login_page.navigate_to_login()
    assert '/login' in context.login_page.driver.current_url

@given('the user is logged in as "{username}"')
def step_logged_in_as(context, username):
    """Log in as specified user."""
    # Navigate to login, enter credentials, verify success
    context.login_page.login(username=username, password="SuperSecretPassword!")
    assert context.login_page.is_login_successful()

@when('the user enters username "{username}"')
def step_enter_username(context, username):
    """Enter username."""
    context.login_page.enter_username(username)

@when('the user enters username ""')
def step_enter_username_empty(context):
    """Enter empty username."""
    context.login_page.enter_username("")

@when('the user enters password "{password}"')
def step_enter_password(context, password):
    """Enter password."""
    context.login_page.enter_password(password)

@when('the user enters password ""')
def step_enter_password_empty(context):
    """Enter empty password."""
    context.login_page.enter_password("")

@when('the user clicks the login button')
def step_click_login(context):
    """Click login button."""
    context.login_page.click_login()

@when('the user clicks the logout button')
def step_click_logout(context):
    """Click logout button."""
    context.login_page.click_logout()

@then('the user should be logged in successfully')
def step_logged_in_successfully(context):
    """Verify successful login."""
    assert context.login_page.is_login_successful()

@then('the user should see welcome message "{message}"')
def step_see_welcome_message(context, message):
    """Verify welcome message."""
    assert message in context.login_page.get_flash_message()

@then('the user should be logged out')
def step_logged_out(context):
    """Verify logout."""
    assert 'logged out' in context.login_page.get_flash_message()

@then('the user should see message "{message}"')
def step_see_message(context, message):
    """Verify message displayed."""
    assert message in context.login_page.get_flash_message()

@then('the login result should be "{result}"')
def step_login_result(context, result):
    """Verify login result."""
    match result:
        case 'success':
            assert context.login_page.is_login_successful()
        case _:
            assert not context.login_page.is_login_successful()