@login
Feature: Login
  A feature to test a login to a application

  Background: Go to URL
    Given a user is on the home page
    When  a user navigates to the Login page using "http://adactinhotelapp.com/index.php"


  Scenario Outline: Login successful

    And a user enter "<username>" and "<password>"
    And a user clicks the login button
    Then a user is loggen in successfully

    Examples:
    |username|password|
    |  AutoTestb      |  K5K9P7      |


  Scenario Outline: Login successful

    And a user enter "<username>" and "<password>"
    And a user clicks the login button
    Then a user is loggen in successfully

    Examples:
      |username|password|
      |  AutoTestb      |  K5K9P7      |


