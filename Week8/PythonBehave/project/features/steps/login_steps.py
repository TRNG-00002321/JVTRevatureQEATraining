from behave import given, when, then
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as ec
from selenium.webdriver.support.wait import WebDriverWait

BASE_URL = 'https://the-internet.herokuapp.com/'

@given(u'the application is running')
def application_running(context):
    options = Options()
    options.add_argument('--start-maximized')

    context.driver = webdriver.Chrome(options=options)
    context.wait = WebDriverWait(context.driver, 10)

    context.driver.get(BASE_URL)

    heading = context.wait.until(ec.visibility_of_element_located((By.TAG_NAME, 'h1')))
    assert heading.text == 'Welcome to the-internet'

@given(u'the test database is already seeded with users')
def database_seeded_with_users(context):
    return True

@given(u'the user is on the login page')
def user_on_login_page(context):
    context.driver.get(BASE_URL + '/login')
    heading = context.wait.until(ec.visibility_of_element_located((By.TAG_NAME, 'h2')))
    assert 'Login Page' in heading.text

@when(u'the user enters username "{username}"')
def user_enters_username(context, username):
    username_input = context.wait.until(ec.visibility_of_element_located((By.ID, 'username')))
    username_input.clear()
    username_input.send_keys(username)

@when(u'the user enters password "{password}"')
def user_enters_password(context, password):
    password_input = context.wait.until(ec.visibility_of_element_located((By.ID, 'password')))
    password_input.clear()
    password_input.send_keys(password)

@when(u'the user clicks the login button')
def user_clicks_login(context):
    login_button = context.wait.until(ec.visibility_of_element_located((By.CSS_SELECTOR, '.fa.fa-2x.fa-sign-in')))
    login_button.click()

@then(u'the user should be redirected to the secure area')
def step_impl(context):
    context.wait.until(ec.url_contains('/secure'))
    assert '/secure' in context.driver.current_url

@then(u'the page should display a message containing "{message_text}"')
def step_impl(context, message_text):
    flash_element = context.wait.until(ec.visibility_of_element_located((By.ID, 'flash')))
    assert message_text in flash_element.text