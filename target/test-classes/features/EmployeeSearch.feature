Feature: Employee search related scenarios

  Scenario: Search employee by id
    Given user is navigated to HRMS application
    When user enters valid username and password
    And user clicks on login button
    Then user is successfully logged in
    When user clicks on PIM option
    And user clicks on employee list option
    When user enters valid employee id
    And user clicks on search button
    Then user see the employee information

    Scenario: Search employee by name
      Given user is navigated to HRMS application
      When user enters valid username and password
      And user clicks on login button
      Then user is successfully logged in
      When user clicks on PIM option
      And user clicks on employee list option
      When user enters valid employee name
      And user clicks on search button
      Then user see the employee information