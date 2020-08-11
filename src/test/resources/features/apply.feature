Feature: Apply

  @single
  Scenario: Successful to the  website
    Given I open chrome browser
    When I maximize browser
    And I click on link
    And I choose South Africa
    Then I should choose first option
    When I send keys
    Then I should get message

