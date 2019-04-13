Feature: User

  Scenario: Get user's login
    Given I have a user
    When I try to get user's login
    Then I should get user's login

  Scenario: Get user's password
    Given I have a user
    When I try to get user's password
    Then I should get user's password

  Scenario Outline: Add friend
    Given I have a server
    Given I have a receiver
    When Server try to send friendship request to receiver
    And I try to check successful bid request
    Then I should get true <result>

  Examples:
    | result |
    | addFriendResult |
    | confirmFriendshipResult |