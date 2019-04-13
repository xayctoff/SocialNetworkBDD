Feature: User

  Scenario: Get user's login
    Given I have a user
    When I try to get user's login
    Then I should get user's login

  Scenario: Get user's password
    Given I have a user
    When I try to get user's password
    Then I should get user's password

  Scenario: Add friend
    Given I have a server
    Given I have a receiver
    When Server try to send friendship request to receiver
    And I try to check users on request
    Then I should get true result after request

  Scenario: Confirm friendship
    Given I have a server
    Given I have a receiver
    When Receiver try to confirm friendship request from server
    And I try to check users on friendship
    Then I should get true result after confirm

  Scenario: Write message
    Given I have a server
    Given I have a receiver
    Given I have a message
    When Server try to send message to receiver
    Then Receiver should get the message