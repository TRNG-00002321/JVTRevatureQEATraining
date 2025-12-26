@forms
Feature: Form Interactions
  As a user
  I want to interact with various form elements
  So that I can complete different tasks

  @checkboxes
  Scenario: Toggle checkboxes
    Given the user is on the checkboxes page
    When the user checks all checkboxes
    Then all checkboxes should be checked
    When the user unchecks all checkboxes
    Then all checkboxes should be unchecked

  @dropdown
  Scenario Outline: Select dropdown options
    Given the user is on the dropdown page
    When the user selects "<option>" from the dropdown
    Then the dropdown should show "<option>" selected

    Examples:
      | option   |
      | Option 1 |
      | Option 2 |

  @input
  Scenario: Clear and type in input field
    # TODO: Design and implement together
    # Use the inputs page or key presses page

  @upload
  Scenario: Upload a file
    # TODO: Design and implement together
    # Use the file upload page