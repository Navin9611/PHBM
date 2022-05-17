# @Author: Naveen Reddy
# Date:
# Suites: @Smoke @Regression

# Functionality
#			1. Login to Mambu
#			2. Go To global Navigation Click on Create
#			3. Click on Client from Options
#			4. Enter FirstName, LastName
#			5. Click on Cancel Button
#			6. LogOut from Mambu
#			7. Close the Browser 

# Files Added
#		1.PHBM -> src/test/java -> com.phbm.ui.teststeps -> CreateClient.java
#		2.PHBM -> src/main/java -> com.phbm.ui.pages -> CreateClientPage.java
#		3.PHBM -> src/main/java -> com.phbm.ui.teststeps.data -> ClientData.java

# Files Modifiles
#		1.PHBM -> src/test/resources -> ui.properties -> OR.properties   - Added all object identifications of the page
#		2.PHBM -> src/main/java -> phbm.ui.utilities -> PageObjectManager.java


@Clients
Feature: Creating Clients
  Creation of Clients

  Background: Logged In
    Given I am logged into Mambu
    And I click on 'Create' in top menu
    And click on 'Client'

  @CreateClient
  Scenario Outline: Creation of Clients
    When go to 'create client' page
    And enter client details
      | FirstName   | LastName   |
      | <FirstName> | <LastName> |
    Then click on Cancel button

    Examples: 
      | FirstName | LastName |
      | Automation     | QA   |
