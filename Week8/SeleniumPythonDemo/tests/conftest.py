import pytest
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.support.ui import WebDriverWait
from webdriver_manager.chrome import ChromeDriverManager


@pytest.fixture(scope="function")
def driver():
    chrome_options = Options()
    chrome_options.add_argument("--headless=new")
    chrome_options.add_argument("--window-size=1920,1080")
    chrome_options.add_argument("--no-sandbox")  # Required for Docker/CI
    chrome_options.add_argument("--disable-dev-shm-usage")  # Overcome limited resources
    chrome_options.add_argument("--disable-gpu")  # Disable GPU hardware acceleration
    chrome_options.add_argument("--disable-extensions")  # Disable extensions
    chrome_options.add_argument("--incognito")  # Incognito mode
    chrome_options.add_argument("--disable-popup-blocking")  # Allow popups
    chrome_options.add_argument("--disable-images")  # Don't load images
    chrome_options.add_argument("--blink-settings=imagesEnabled=false")

    service = Service(ChromeDriverManager().install())
    driver = webdriver.Chrome(service=service, options=chrome_options)

    try:
        yield driver
    finally:
        driver.quit()


@pytest.fixture
def wait(driver):
    return WebDriverWait(driver, 10)


@pytest.fixture
def open_url(driver):
    def _open(url):
        driver.get(url)
    return _open


@pytest.fixture
def login(driver):
    def _login(username, password):
        driver.find_element("id", "username").clear()
        driver.find_element("id", "password").clear()

        driver.find_element("id", "username").send_keys(username)
        driver.find_element("id", "password").send_keys(password)
        driver.find_element("css selector", "button[type='submit']").click()

    return _login