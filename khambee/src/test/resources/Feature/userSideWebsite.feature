Feature: Checking the user side Landing and course page

  Background: 
    Given user is on login page
    When user enters sudeshnashetty2211@gmail.com and CreatorX@123
    And user clicks on login
    Then user is navigated to the home page

  Scenario Outline: Verify user is able to navigate to User website
    Given user is on the web site page
    And user clicks on visit website
    Then user should be navigated to his website
    When user clicks on enroll now on landing page
    Then user will navigate to <course page>
    And user clicks on enroll now on course page
    And student fills the form <fullname>, <email>, <mobile number>
    When student clicks on Book your seat
    Then seat should be booked for the student with confirmation <message>

    Examples: 
      | course page | fullname | email                    | mobile number | message                                   |
      | Testing     | sudeshna | sudeshnashetty@gmail.com |    9133690791 | Your Seat for the course has been Booked! |
