Feature: Account Page Feature

  Background:
    Given user has already logged in to application
      |username|password|
      |vbhanu|Bhanu@M1|


  Scenario: Accounts page title
    Given user is on Home page
    When user gets the title of the page
    Then page title should be "CRMPRO"


  Scenario: Accounts section count
    Given user is on Home page
    Then user gets headers section
      |CRMPRO News|
      |Week Calendar: Week 18|
      |Week 18, 2023|
      |Flaged Records|
      |Calendar|
      |Tags |
      |Email Campaigns|
      |Saturday May 6, 2023|
      |Quick Create|
      |Scheduled Calls|
      |Call List (not scheduled)|
    And accounts section count should be 11