"""
Form Page Object
"""
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
from pages.base_page import BasePage
from selenium.webdriver.support import expected_conditions as ec

class FormPage(BasePage):
    # Locators
    CHECKBOXES = (By.TAG_NAME, "input")
    DROPDOWN = (By.ID, "dropdown")

    def navigate_to_checkboxes(self):
        self.navigate_to("/checkboxes")

    def check_all_checkboxes(self):
        checkboxes = self.wait.until(ec.visibility_of_all_elements_located(self.CHECKBOXES))
        for checkbox in checkboxes:
            if not checkbox.is_selected():
                checkbox.click()

    def uncheck_all_checkboxes(self):
        checkboxes = self.wait.until(ec.visibility_of_all_elements_located(self.CHECKBOXES))
        for checkbox in checkboxes:
            if checkbox.is_selected():
                checkbox.click()

    def is_all_checkboxes_checked(self):
        is_all_selected = True
        checkboxes = self.wait.until(ec.visibility_of_all_elements_located(self.CHECKBOXES))
        for checkbox in checkboxes:
            is_all_selected = is_all_selected and checkbox.is_selected()
        return is_all_selected

    def is_all_checkboxes_unchecked(self):
        is_all_unchecked = True
        checkboxes = self.wait.until(ec.visibility_of_all_elements_located(self.CHECKBOXES))
        for checkbox in checkboxes:
            is_all_unchecked = is_all_unchecked and not checkbox.is_selected()
        return is_all_unchecked

    def navigate_to_dropdown(self):
        self.navigate_to("/dropdown")

    def select_from_dropdown(self, option_text):
        select_obj = Select(self.wait_for_element(self.DROPDOWN))
        select_obj.select_by_visible_text(option_text)

    def is_dropdown_option_selected(self, option_text):
        select_obj = Select(self.wait_for_element(self.DROPDOWN))
        dropdown_option = select_obj.first_selected_option
        return dropdown_option.text == option_text