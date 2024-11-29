Feature: Add Item Controller API tests

  Scenario Outline: <name>
    Given User is logged in
    When Post Add Item Request with quantity "<quantity>", product_id <product_id>, return_cart "<return_cart>"
    Then Assert that add item response code is "<scenario>"
    And Log out user

    Examples:
      | name                       | quantity | product_id | return_cart | scenario                |
      | postCorrectAddItemResponse | 5        | 1690       | true        | correctRequest          |

  Scenario Outline: <name>
    Given User is logged in
    When Post Add Item Request with empty body
    Then Assert that add item response code is "<scenario>"
    And Log out user

    Examples:
      | name                           | scenario                |
      | postAddItemWithoutBodyResponse | correctRequest          |

  Scenario Outline: <name>
    Given User is logged in
    When Post Add Item Request with nulls in body
    Then Assert that add item response code is "<scenario>"
    And Log out user

    Examples:
      | name                           | scenario                |
      | postAddItemWithoutBodyResponse | correctRequest          |
