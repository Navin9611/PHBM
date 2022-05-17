@Smoke
Feature: Login to Mambu

  Scenario: Login to MAMBU with Valid Credentials
    Given User navigates to mambu application
    When User enters valid credentials
    And click on the submit button
    Then login must be successful