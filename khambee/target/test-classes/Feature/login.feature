Feature: Test login functionality

  Scenario Outline: Check login with valid credentials
    Given user is on login page
    When user enters <user name> and <password>
    And user clicks on login
    Then user is navigated to the home page

    Examples: 
      | user name                    | password     |
      | sudeshnashetty2211@gmail.com | CreatorX@123 |
      |                   9133690791 | CreatorX@123 |

  Scenario Outline: Check login with invalid credentials
    Given user is on login page
    When user enters <user name> and <password>
    And user clicks on login
    Then an error message should be displayed

    Examples: 
      | user name                    | password     |
      | sudeshnashetty2211@gmail.com | CreatorX     |
      |                   9133690791 | CreatorX     |
      | sudeshnashetty2211@gmail.com |              |
      |                   9133690791 |              |
      | sudeshnashetty2211           | CreatorX@123 |
      |                   1896469712 | CreatorX@123 |

  Scenario Outline: Check login with  empty emailId
    Given user is on login page
    When user enters  <user name>  and  <password>
    And user clicks on login
    Then Login should be disabled

    Examples: 
      | user name | password  |
      |           | CreatorX@ |
      |           |           |
