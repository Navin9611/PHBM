@Regression
Feature: Client Search
  Search the existing Client
  
  Background: Logged In
    Given logged into Mambu

  @SearchClient
  Scenario: Search for existing client
    When Go to mambu landing page
    And Enter existing client name 
    Then Navigate to Client details Page
