Feature: Count Item Controller API tests

  Scenario Outline: <name>
    Given User is logged in
    When Get Count Item Response
    Then  Assert that count item response code is <responseCode>
    And Log out user

    Examples:
      | name                  | responseCode |
      | getCountItemResponse | 200          |

  Scenario Outline: <name>
    Given User is logged in
    When Get Count Item
    Then  Assert that count item response code is <responseCode>
    And Log out user

    Examples:
      | name          | responseCode |
      | getCountItem | 200          |
