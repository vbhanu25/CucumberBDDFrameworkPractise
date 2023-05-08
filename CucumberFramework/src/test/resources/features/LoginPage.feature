Feature: Login page feature

  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Free CRM - CRM software for customer relationship management, sales, and support."


  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username "vbhanu"
    And user enters password "Bhanu@M1"
    And user clicks on Login button
    Then user gets the title of the page
    And page title should be "CRMPRO"