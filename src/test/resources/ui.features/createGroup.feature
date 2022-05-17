
Feature: Creating Groups
  Creation of Groups

  Background: Logged In
    Given I am logged into Mambu
    And click on 'Create' in top menu
    And I click on 'Group'

  @CreateGroup
  Scenario: Creation of Group
    When go to create group page
    And enter group name
    Then click on the Cancel button