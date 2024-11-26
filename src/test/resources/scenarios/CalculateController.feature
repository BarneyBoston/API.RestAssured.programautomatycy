Feature: Calculate Controller API tests

  Scenario Outline: <name>
    Given User is logged in
    When Post Calculate Item Request with return_cart "<return_cart>"
    Then  Assert that calculate response code is <responseCode>
    And Log out user

    Examples:
      | name                  | return_cart | responseCode |
      | postCalculateResponse | true        | 200          |
