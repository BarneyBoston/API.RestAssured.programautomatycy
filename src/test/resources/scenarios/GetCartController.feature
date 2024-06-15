Feature: Get Cart Controller API tests

  Scenario Outline: <name>
    Given User is logged in
    When Get Cart Response
    Then  Assert that get cart response code is <responseCode>
    And Log out user

    Examples:
      | name                  | responseCode |
      | getCartResponse | 200          |

  Scenario Outline: <name>
    Given User is logged in
    When Get Cart Id Response
    Then  Assert that get cart response code is <responseCode>
    And Log out user

    Examples:
      | name              | responseCode |
      | getCartIdResponse | 200          |
