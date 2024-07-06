Feature: Login related scenarios

  @smoke @sprint1 @diane @luckycharm @regression @failed
  Scenario: Valid admin login
    #Given user is navigated to HRMS application
    When user enters valid username and password
    And user clicks on login button
    Then user is successfully logged in

   @featurefile @smoke @regression
   Scenario: Valid admin login using feature file
     When user enters "admin" value and "Hum@nhrm123" value
     And user clicks on login button
     Then user is successfully logged in

   @datadriven @smoke @regression
   Scenario Outline: login multiple times
     When user enters "<username>" values and "<password>" values
     And user clicks on login button
     Then user is successfully logged in
     Examples:
       | username | password |
       |admin     |Hum@nhrm123|
       |admin     |Hum@nhrm123|
       |admin     |Hum@nhrm123|



