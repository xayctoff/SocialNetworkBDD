Feature: Database

  Scenario: Connect to the database
    Given I haven't connection to the database
    When I try to connect to the database
    Then I should connect to the database

  Scenario: Connect to the database again
    Given I have connection to the database
    When I try to connect to the database
    Then I should get current connection

  Scenario: Valid authorization check
    Given I have a login
    Given I have a password
    When I try to check valid authorization
    Then I should to pass validation