Feature: Clear Item Controller API tests

  Scenario Outline: <name>
    Given User is logged in
    When Post Clear Item Response
    Then Assert that clear item response code is "<scenario>"
    And Log out user

    Examples:
      | name                  | scenario |
      | postClearItemResponse | correctRequest          |

  Scenario Outline: <name>
    Given User is logged in
    When Post Clear Item
    Then Assert that clear item response code is "<scenario>"
    And Log out user

    Examples:
      | name          | scenario |
      | postClearItem | correctRequest          |
