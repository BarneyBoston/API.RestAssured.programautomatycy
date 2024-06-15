Feature: Clear Item Controller API tests

  Scenario Outline: <name>
    Given User is logged in
    When Post Clear Item Response
    Then  Assert that clear item response code is <responseCode>
    And Log out user

    Examples:
      | name                  | responseCode |
      | postClearItemResponse | 200          |

  Scenario Outline: <name>
    Given User is logged in
    When Post Clear Item
    Then  Assert that clear item response code is <responseCode>
    And Log out user

    Examples:
      | name          | responseCode |
      | postClearItem | 200          |
