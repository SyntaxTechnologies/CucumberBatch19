Feature: Adding employees using different techniques

  Background:
     #Given user is navigated to HRMS application
    When user enters valid username and password
    And user clicks on login button
    Then user is successfully logged in
    When user clicks on PIM option
    And user clicks on Add Employee option


  @addemployee @regression @failed
  Scenario: Adding an employee in HRMS system
    When user enters firstname and middlename and lastname
    And user clicks on save button
    Then employee added successfully

    @cucumber @regression
    Scenario: Adding employee from feature file
      When user enters "Sheila" , "MS" and "Bangal"
      And user clicks on save button
      Then employee added successfully

  @ddt @regression
  Scenario Outline: Adding employees using data driven testing
    When user enters "<firstname>" and "<middlename>" and "<lastname>".
    And user clicks on save button
    Then employee added successfully
    Examples:
      | firstname | middlename | lastname |
      |Fouad      |MS          |Oliinyk   |
      |Matt       |MS          |Aslloun   |
      |Lali       |MS          |Shahad    |


  @datatable @regression
  Scenario: Adding multiple employees using data table
    When user enters firstname and middlename and lastname from data table and verify it
    |firstname|middlename|lastname|
    |aleni    |MS        |hina    |
    |hali     |MS        |marina  |
    |wilkola  |MS        |fabrezy |

  @excel
  Scenario: Adding employees from excel file
    When user adds multiple employees from excel and validate them
