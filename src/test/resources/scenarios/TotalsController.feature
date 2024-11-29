Feature: Totals Controller API tests

  Scenario Outline: <name>
    Given User is logged in
    When Get Totals Response
    Then  Assert that totals response code is "<scenario>"
    And Log out user

    Examples:
      | name                | scenario       |
      | Get Totals Response | correctRequest |

  Scenario Outline: <name>
    Given User is logged in
    When Get Totals
    Then  Assert that totals response code is "<scenario>"
    And Log out user

    Examples:
      | name       | scenario       |
      | Get Totals | correctRequest |