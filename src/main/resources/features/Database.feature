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

  Scenario: Check for user existence
    Given I have a login
    When I try to check user existence
    Then I should get true result

  Scenario: Insert
    Given I have a query
    When I try to insert record in the database
    Then I should get 1 because I insert one record

  Scenario: Update
    Given I have a query
    When I try to update record in the database
    Then I should get 1 because I update one record