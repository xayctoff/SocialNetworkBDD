Feature: User

  Scenario: Get user's login
    Given I have a user
    When I try to get user's login
    Then I should get user's login