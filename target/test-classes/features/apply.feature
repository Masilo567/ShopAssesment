Feature: Apply

  @single
  Scenario: Successful apply to the ilab website
    Given I open chrome browser
    When I maximize browser
    And I click on career link
    And I choose South Africa
    Then I should choose first job
    When I send keys
    Then I should get message
