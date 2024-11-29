Feature: Count Item Controller API tests

  Scenario Outline: <name>
    Given User is logged in
    When Get Count Item Response
    Then  Assert that count item response code is "<scenario>"
    And Log out user

    Examples:
      | name                  | scenario                |
      | getCountItemResponse  | correctRequest          |

  Scenario Outline: <name>
    Given User is logged in
    When Get Count Item
    Then  Assert that count item response code is "<scenario>"
    And Log out user

    Examples:
      | name         | scenario |
      | getCountItem | correctRequest          |
