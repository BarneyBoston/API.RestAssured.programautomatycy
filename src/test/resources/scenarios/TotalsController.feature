Feature: Totals Controller API tests

  Scenario: Get Totals Response
    Given User is logged in
    When Get Totals Response
    Then  Assert that totals response code is 200
    And Log out user

  Scenario: Get Totals
    Given User is logged in
    When Get Totals
    Then  Assert that totals response code is 200
    And Log out user