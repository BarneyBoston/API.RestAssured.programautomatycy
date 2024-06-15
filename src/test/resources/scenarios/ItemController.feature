Feature: Item Controller API tests

  Scenario: Get Correct Item Response
    Given User is logged in
    When Get Correct Item Response
    Then  Assert that item response code is 200
    And Log out user

  Scenario: Get Incorrect Item Response
    Given User is logged in
    When Get Incorrect Item Response
    Then  Assert that item response code is 403
    And Log out user

  Scenario: Get Null Item Response
    Given User is logged in
    When Get Null Item Response
    Then  Assert that item response code is 400
    And Log out user

  Scenario: Post Correct Item Response
    Given User is logged in
    When Post Correct Item Response
    Then  Assert that item response code is 200
    And Log out user

  Scenario: Post Incorrect Item Response
    Given User is logged in
    When Post Incorrect Item Response
    Then  Assert that item response code is 404
    And Log out user

  Scenario: Post Null Item Response
    Given User is logged in
    When Post Null Item Response
    Then  Assert that item response code is 400
    And Log out user

  Scenario: Delete Item Response
    Given User is logged in
    When Delete Item Response
    Then  Assert that item response code is 200
    And Log out user

  Scenario: Delete Incorrect Item Response
    Given User is logged in
    When Delete Incorrect Item Response
    Then  Assert that item response code is 404
    And Log out user

  Scenario: Delete Null Item Response
    Given User is logged in
    When Delete Null Item Response
    Then  Assert that item response code is 400
    And Log out user

  Scenario: Get Item
    Given User is logged in
    When Get Item
    Then  Assert that item response code is 200
    And Log out user

  Scenario: Update Item
    Given User is logged in
    When Update Item
    Then  Assert that item response code is 200
    And Log out user

  Scenario: Delete Item
    Given User is logged in
    When Delete Item
    Then  Assert that item response code is 403
    And Log out user