Feature: Apply

  @single
  Scenario: Successful to the  website
    Given I open chrome browser
    When I maximize browser
    And I click search product
    And I click on product
    Then I verify product
    When I send keys
    Then I should get message

