"""
Form Step Definitions
"""
from behave import given, when, then

# Checkboxes
@given('the user is on the checkboxes page')
def step_on_checkboxes_page(context):
    context.form_page.navigate_to_checkboxes()
    assert '/checkboxes' in context.form_page.driver.current_url

@when('the user checks all checkboxes')
def step_check_all_checkboxes(context):
    context.form_page.check_all_checkboxes()

@when('the user unchecks all checkboxes')
def step_uncheck_all_checkboxes(context):
    context.form_page.uncheck_all_checkboxes()

@then('all checkboxes should be checked')
def step_all_checked(context):
    assert context.form_page.is_all_checkboxes_checked()

@then('all checkboxes should be unchecked')
def step_all_unchecked(context):
    assert context.form_page.is_all_checkboxes_unchecked()

# Dropdowns
@given('the user is on the dropdown page')
def step_on_dropdown_page(context):
    context.form_page.navigate_to_dropdown()
    assert '/dropdown' in context.form_page.driver.current_url

@when('the user selects "{option}" from the dropdown')
def step_select_option(context, option):
    context.form_page.select_from_dropdown(option)

@then('the dropdown should show "{option}" selected')
def step_verify_selected(context, option):
    assert context.form_page.is_dropdown_option_selected(option)

# Inputs
# TODO: Implement feature clauses

# Uploads
# TODO: Implement feature clauses