"""
Test page content validation using Python Selenium.

Implement tests that:
1. Validate page title
2. Check for specific text content
3. Verify element presence
4. Check element attributes
"""
from selenium.common import NoSuchElementException
from selenium.webdriver.common.by import By
import sys
from selenium.webdriver.support import expected_conditions as ec
from selenium.webdriver.support.wait import WebDriverWait
from selenium.common.exceptions import TimeoutException

sys.path.insert(0, '..')
from utils.driver_factory import create_chrome_driver

BASE_URL = "https://the-internet.herokuapp.com/"

def test_page_title():
    """Verify the page title matches expected value."""
    # YOUR CODE HERE
    with create_chrome_driver(True) as driver:
        driver.get(BASE_URL)
        assert "The Internet" in driver.title

def test_heading_text():
    """Verify the main heading contains expected text."""
    # YOUR CODE HERE
    with create_chrome_driver(True) as driver:
        driver.get(BASE_URL)
        assert "Welcome to the-internet" in driver.find_element(By.CSS_SELECTOR, "h1").text

def test_links_present():
    """Verify that all example links are present on the page."""
    # YOUR CODE HERE
    # Use find_elements to get all links
    # Use list comprehension to extract link texts
    with create_chrome_driver(True) as driver:
        driver.get(BASE_URL)
        all_links = driver.find_elements(By.TAG_NAME, "a")
        link_texts = [link.text for link in all_links if link.text.strip()]
        for expected_text in link_texts:
            try:
                driver.find_element(By.LINK_TEXT, expected_text)
            except NoSuchElementException:
                # If the element is not found, raise an assertion error
                assert False, f"Assertion failed: '{expected_text}' element could not be re-located using By.LINK_TEXT"

def test_link_attributes():
    """Verify that links have correct href attributes."""
    # YOUR CODE HERE
    expected_hrefs = [
        "https://github.com/tourdedave/the-internet",
        "/abtest",
        "/add_remove_elements",
        "/basic_auth",
        "/broken_images",
        "/challenging_dom",
        "/checkboxes",
        "/context_menu",
        "/digest_auth",
        "/disappearing_elements",
        "/drag_and_drop",
        "/dropdown",
        "/dynamic_content",
        "/dynamic_controls",
        "/dynamic_loading",
        "/entry_ad",
        "/exit_intent",
        "/download",
        "/upload",
        "/floating_menu",
        "/forgot_password",
        "/login",
        "/frames",
        "/geolocation",
        "/horizontal_slider",
        "/hovers",
        "/infinite_scroll",
        "/inputs",
        "/jqueryui/menu",
        "/javascript_alerts",
        "/javascript_error",
        "/key_presses",
        "/large",
        "/windows",
        "/nested_frames",
        "/notification_message",
        "/redirector",
        "/download_secure",
        "/shadowdom",
        "/shifting_content",
        "/slow",
        "/tables",
        "/status_codes",
        "/typos",
        "/tinymce",
        "http://elementalselenium.com/"
    ]
    timeout = 10
    with create_chrome_driver(True) as driver:
        driver.get(BASE_URL)
        try:
            all_links = WebDriverWait(driver, timeout).until(
                ec.presence_of_all_elements_located((By.TAG_NAME, "a"))
            )
            actual_hrefs = [link.get_attribute("href") for link in all_links]
            assert len(actual_hrefs) == len(expected_hrefs)
            for expected_href, actual_href in zip(expected_hrefs, actual_hrefs):
                assert expected_href in actual_href, f"'{expected_href}' not found in '{actual_href}'"
        except TimeoutException:
            assert False, f"Timeout: Not all links were visible within the specified time of {timeout} seconds."