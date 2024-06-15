Feature: Add Item Controller API tests

  Scenario Outline: <name>
    Given User is logged in
    When Post Add Item Request with quantity "<quantity>", product_id <product_id>, return_cart "<return_cart>"
    Then  Assert that add item response code is <responseCode>
    And Log out user

    Examples:
      | name                       | quantity | product_id | return_cart | responseCode |
      | postCorrectAddItemResponse | 5        | 1690       | true        | 200          |

  Scenario Outline: <name>
    Given User is logged in
    When Post Add Item Request with empty body
    Then  Assert that add item response code is <responseCode>
    And Log out user

    Examples:
      | name                           | responseCode |
      | postAddItemWithoutBodyResponse | 404          |

  Scenario Outline: <name>
    Given User is logged in
    When Post Add Item Request with nulls in body
    Then  Assert that add item response code is <responseCode>
    And Log out user

    Examples:
      | name                           | responseCode |
      | postAddItemWithoutBodyResponse | 400          |
