Feature: Item Controller API tests

  Scenario Outline: <name>
    Given User is logged in
    When Get Correct Item Response
    Then  Assert that item response code is "<scenario>"
    And Log out user

    Examples:
      | name                      | scenario       |
      | Get Correct Item Response | correctRequest |

  Scenario Outline: <name>
    Given User is logged in
    When Get Incorrect Item Response
    Then  Assert that item response code is "<scenario>"
    And Log out user

    Examples:
      | name                        | scenario       |
      | Get Incorrect Item Response | correctRequest |

  Scenario Outline: <name>
    Given User is logged in
    When Get Null Item Response
    Then  Assert that item response code is "<scenario>"
    And Log out user

    Examples:
      | name                   | scenario       |
      | Get Null Item Response | correctRequest |

  Scenario Outline: <name>
    Given User is logged in
    When Post Correct Item Response
    Then  Assert that item response code is "<scenario>"
    And Log out user

    Examples:
      | name                       | scenario       |
      | Post Correct Item Response | correctRequest |

  Scenario Outline: <name>
    Given User is logged in
    When Post Incorrect Item Response
    Then  Assert that item response code is "<scenario>"
    And Log out user

    Examples:
      | name                         | scenario       |
      | Post Incorrect Item Response | correctRequest |

  Scenario Outline: <name>
    Given User is logged in
    When Post Null Item Response
    Then  Assert that item response code is "<scenario>"
    And Log out user

    Examples:
      | name                    | scenario       |
      | Post Null Item Response | correctRequest |

  Scenario Outline: <name>
    Given User is logged in
    When Delete Item Response
    Then  Assert that item response code is "<scenario>"
    And Log out user

    Examples:
      | name                 | scenario       |
      | Delete Item Response | correctRequest |

  Scenario Outline: <name>
    Given User is logged in
    When Delete Incorrect Item Response
    Then  Assert that item response code is "<scenario>"
    And Log out user

    Examples:
      | name                           | scenario       |
      | Delete Incorrect Item Response | correctRequest |

  Scenario Outline: <name>
    Given User is logged in
    When Delete Null Item Response
    Then  Assert that item response code is "<scenario>"
    And Log out user

    Examples:
      | name                      | scenario       |
      | Delete Null Item Response | correctRequest |

  Scenario Outline: <name>
    Given User is logged in
    When Get Item
    Then Assert that item response code is "<scenario>"
    And Log out user

    Examples:
      | name     | scenario       |
      | Get Item | correctRequest |

  Scenario Outline: <name>
    Given User is logged in
    When Update Item
    Then  Assert that item response code is "<scenario>"
    And Log out user

    Examples:
      | name        | scenario       |
      | Update Item | correctRequest |

  Scenario Outline: <name>
    Given User is logged in
    When Delete Item
    Then  Assert that item response code is "<scenario>"
    And Log out user

    Examples:
      | name        | scenario       |
      | Delete Item | correctRequest |