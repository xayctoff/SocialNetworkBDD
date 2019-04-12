Feature: User

  Scenario: Get user's login
    Given I have a user
    When I try to get user's login
    Then I should get user's login

  Scenario: Get user's password
    Given I have a user
    When I try to get user's password
    Then I should get user's password