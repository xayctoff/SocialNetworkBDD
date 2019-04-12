Feature: Login

  Scenario: User authorization
    Given I have an authorization window
    When I entered the user login
    And I entered the user password
    And I pressed sign in button
    Then I have to enter in my page

  Scenario: User registration
    Given I have an authorization window
    When I entered the user login
    And I entered the user password
    And I pressed sign up button
    Then I have to enter in my page after sign up