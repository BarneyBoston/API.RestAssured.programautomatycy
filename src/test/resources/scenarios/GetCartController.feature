Feature: Get Cart Controller API tests

  Scenario Outline: <name>
    Given User is logged in
    When Get Cart Response
    Then Assert that get cart response is "<scenario>"
    And Log out user

    Examples:
      | name             | scenario         |
      | getCartResponse  | correctRequest   |

  Scenario Outline: <name>
    Given User is logged in
    When Get Cart Id Response
    Then Assert that get cart response is "<scenario>"
    And Log out user

    Examples:
      | name             | scenario         |
      | getCartResponse  | correctRequest   |
