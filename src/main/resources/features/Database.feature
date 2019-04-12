Feature: Database

  Scenario: Connect to the database
    Given I haven't connection to the database
    When I try to connect to the database
    Then I should connect to the database

  Scenario: Connect to the database again
    Given I have connection to the database
    When I try to connect to the database
    Then I should get current connection