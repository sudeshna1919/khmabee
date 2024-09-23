Feature: Test course section functionality

  Background: 
    Given user is on login page
    When user enters sudeshnashetty2211@gmail.com and CreatorX@123
    And user clicks on login
    Then user is navigated to the home page

 Scenario: Verify user navigation to course page
    Given user navigates to home page
    When user clicks on course
    Then user should be navigated to his course page

  Scenario: verify user is able to configure course details
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration

  Scenario Outline: Verify if user gets Error message when user leave thumb nail blank in course information section.
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user erased the fields
    And user enters <title>,  <description>
    And user entered <usp1>, <usp2> and <usp3>
    When clicked on save changes
    Then user should gets a toast <message>

    Examples: 
      | title   | description                                                                        | usp1          | usp2     | usp3   | message                          |
      | Testing | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques." | Comprehensive | Hands-On | Expert | Course Thumbnail can't be empty! |
      |         |                                                                                    |               |          |        | Course Name can't be empty!      |
      |         |                                                                                    |               |          |        | Course Name can't be empty!      |




  Scenario Outline: Verify user is able to edit the Basic course information
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user erased the fields
    And user gives <title>, <description> and uploads<image>
    And user entered <usp1>, <usp2> and <usp3>
    When clicked on save changes
    Then user should gets a toast <message>

    Examples: 
      | title                                                                                      | description                                                                                                                                                            | image                                   | usp1                   | usp2            | usp3           | message                                           |
      | Testing                                                                                    | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."                                                                                     | ‪C:\\Users\\DELL\\Downloads\\flower.jpg |                        |                 |                | Fill all the unique selling points!               |
      | Testing                                                                                    | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."                                                                                     | C:\\Users\\DELL\\Downloads\\flower.jpg  | Comprehensive          | Hands-On        | Expert         | Saved Successfully!                               |
      | Testing Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques." | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."                                                                                     | ‪C:\\Users\\DELL\\Downloads\\flower.jpg | Comprehensive          | Hands-On        | Expert         | Course Name can't exceed 50 characters!           |
      | Testing                                                                                    | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."  Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques." | ‪C:\\Users\\DELL\\Downloads\\flower.jpg | Comprehensive          | Hands-On        | Expert         | Course Description can't exceed 120 characters!   |
      | Testing                                                                                    | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."                                                                                     | ‪C:\\Users\\DELL\\Downloads\\flower.jpg | Comprehensive Hands-On | Hands-On Expert | ExpertHands-On | Unique selling points can't exceed 20 characters! |
      |                                                                                            | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."                                                                                     | ‪C:\\Users\\DELL\\Downloads\\flower.jpg | Comprehensive          | Hands-On        | Expert         | Course Name can't be empty!                       |
      | Testing                                                                                    |                                                                                                                                                                        | ‪C:\\Users\\DELL\\Downloads\\flower.jpg | Comprehensive          | Hands-On        | Expert         | Course Description can't be empty!                |

  Scenario Outline: Verify if the user is able to save changes with invalid thumb nail details in the course information section
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user erased the fields
    And user gives <title>, <description>  and uploads <Image>
    And user entered <usp1>, <usp2> and <usp3>
    Then user should gets a toast <message>

    Examples: 
      | title   | description                                                                        | Image                                                      | usp1          | usp2     | usp3   | message                               |
      | Testing | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques." | C:\\Users\\DELL\\Downloads\\Portfolio (1).pdf              | Comprehensive | Hands-On | Expert | File extension should be jpg/jpeg/png |
      | Testing | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques." | C:\\Users\\DELL\\Downloads\\pexels-zhang-kaiyv-1138369.jpg | Comprehensive | Hands-On | Expert | Image size should be less than 5MB    |

  Scenario Outline: Verify user is able to move to the next section after filling the details
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user erased the fields
    And user gives <title>, <description>  and uploads <Image>
    And user entered <usp1>, <usp2> and <usp3>
    When user clicks on next
    Then user should gets a toast <message>
    Then user should be navigated to pricing section

    Examples: 
      | title   | description                                                                        | Image                                  | usp1          | usp2     | usp3   | message             |
      | Testing | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques." | C:\\Users\\DELL\\Downloads\\flower.jpg | Comprehensive | Hands-On | Expert | Saved Successfully! |

  Scenario Outline: Verify user is able to move to next section when clicked on Next with blank details in course information page
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user erased the fields
    And user gives <title>, <description>  and uploads <Image>
    And user entered <usp1>, <usp2> and <usp3>
    When user clicks on next
    Then user should gets a toast <message>

    Examples: 
      | title                                                                                      | description                                                                                                                                                            | Image                                    | usp1                   | usp2            | usp3           | message                                                |
      |                                                                                            | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."                                                                                     | C:\\Users\\DELL\\Downloads\\flower.jpg   | Comprehensive          | Hands-On        | Expert         | Course Name can't be empty!                            |
      | Testing                                                                                    |                                                                                                                                                                        | ‪‪C:\\Users\\DELL\\Downloads\\flower.jpg | Comprehensive          | Hands-On        | Expert         | Course Description can't be empty!                     |
      | Testing Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques." | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."                                                                                     | C:\\Users\\DELL\\Downloads\\flower.jpg   | Comprehensive          | Hands-On        | Expert         | Course Name can't exceed 50 characters!                |
      | Testing                                                                                    | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."  Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques." | C:\\Users\\DELL\\Downloads\\flower.jpg   | Comprehensive          | Hands-On        | Expert         | Course Description can't exceed 120 characters!        |
      | Testing                                                                                    | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."                                                                                     | C:\\Users\\DELL\\Downloads\\flower.jpg   | Comprehensive Hands-On | Hands-On Expert | ExpertHands-On | Unique selling points can't exceed than 20 characters! |
      | Testing                                                                                    | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."                                                                                     | C:\\Users\\DELL\\Downloads\\flower.jpg   |                        |                 |                | Fill all the unique selling points!                    |


  Scenario Outline: Toggle course payment status
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on pricing
    And the user toggles the course to <status>
    When clicked on save changes
    Then the course should be marked as <status>

    Examples: 
      | status |
      | Paid   |
      | Free   |

  Scenario Outline: Verify user is able to set course price
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on pricing
    And user checks the toggle and makes it paid if it is free
    And user sets <price> for the course
    When clicked on save changes
    Then user should gets a toast <message>

    Examples: 
      | price  | message                            |
      |     10 | Saved Successfully!                |
      |    200 | Saved Successfully!                |
      |   1000 | Saved Successfully!                |
      | 200000 | Saved Successfully!                |
      |      0 | Full Price can't be empty or zero! |
      |        | Full Price can't be empty or zero! |

  Scenario Outline: Verify user is able to set course price more than 200000
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on pricing
    And user checks the toggle and makes it paid if it is free
    And user sets <price> for the course
    Then user should gets a toast <message>

    Examples: 
      | price  | message                                     |
      | 250000 | You can't set course price more than 200000 |

  Scenario Outline: Verify user is able to enter discounted price without Full price
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on pricing
    And user checks the toggle and makes it paid if it is free
    And user sets <price> for the course
    When user fills <discounted price>
    Then user should gets a toast <message>

    Examples: 
      | price | discounted price | message                   |
      |       |               10 | Please enter Course Price |
      |     0 |               10 | Please enter Course Price |

  Scenario Outline: Verify user is able to enter discounted price and discount percentage should be updated
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on pricing
    And user checks the toggle and makes it paid if it is free
    And user sets <price> for the course
    When user fills <discounted price>
    Then <discounted percentage> should be updated
    When clicked on save changes
    Then user should gets a toast <message>

    Examples: 
      | price | discounted price | discounted percentage | message             |
      |  1000 |               10 |                    99 | Saved Successfully! |
      | 25000 |              500 |                    98 | Saved Successfully! |
      |  5000 |              499 |                 90.02 | Saved Successfully! |
      |   100 |                0 |                   100 | Saved Successfully! |

  Scenario Outline: Verify user is able to enter discount percentage without full price
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on pricing
    And user checks the toggle and makes it paid if it is free
    And user sets <price> for the course
    When user filled <discounted percentage>
    Then user should gets a toast <message>

    Examples: 
      | price | discounted percentage | message                   |
      |       |                    48 | Please enter Course Price |
      |     0 |                    25 | Please enter Course Price |

  Scenario Outline: Verify user is able to enter discount percentage and discounted price should be updated
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on pricing
    And user checks the toggle and makes it paid if it is free
    And user sets <price> for the course
    When user filled <discounted percentage>
    Then <discounted price> should get updated
    When clicked on save changes
    Then user should gets a toast <message>

    Examples: 
      | price | discounted percentage | discounted price | message             |
      |  3500 |                    48 |             1820 | Saved Successfully! |
      |   348 |                    12 |              306 | Saved Successfully! |
      |   100 |                     0 |              100 | Saved Successfully! |

  Scenario Outline: Verify user is able to set international price for the course
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on pricing
    And user checks the toggle and makes it paid if it is free
    And user clicks on check box for international price
    And user set international <price> for the course
    When clicked on save changes
    Then user should gets a toast <message>

    Examples: 
      | price | message                                     |
      |    10 | Saved Successfully!                         |
      |   200 | Saved Successfully!                         |
      |  1000 | Saved Successfully!                         |
      |  2000 | Saved Successfully!                         |
      |     0 | International Price can't be empty or zero! |
      |       | International Price can't be empty or zero! |

  Scenario Outline: Verify user is able to set international price for the course more than 2500$
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on pricing
    And user checks the toggle and makes it paid if it is free
    And user clicks on check box for international price
    And user set international <price> for the course
    Then user should gets a toast <message>

    Examples: 
      | price | message                                   |
      |  3000 | You can't set course price more than 2500 |
 



  Scenario Outline: Verify user is able to enter discounted price without international price
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on pricing
    And user checks the toggle and makes it paid if it is free
    And user clicks on check box for international price
    And user set international <price> for the course
    When user is entering <discounted price>
    Then user should gets a toast <message>

    Examples: 
      | price | discounted price | message                           |
      |     0 |               10 | Please enter International Course Price |
      |       |               10 | Please enter International Course Price |

  Scenario Outline: Verify user is able to enter discounted price and discount percentage should be updated in international price
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on pricing
    And user checks the toggle and makes it paid if it is free
    And user clicks on check box for international price
    And user set international <price> for the course
    When user is entering <discounted price>
    Then <discounted percentage> should is updated
    When clicked on save changes
    Then user should gets a toast <message>

    Examples: 
      | price | discounted price | discounted percentage | message             |
      |  1000 |               10 |                    99 | Saved Successfully! |
      |  2500 |              500 |                    98 | Saved Successfully! |
      |   100 |                0 |                   100 | Saved Successfully! |

  Scenario Outline: Verify user is able to enter discount percentage and discounted price should be updated in international price
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on pricing
    And user checks the toggle and makes it paid if it is free
    And user clicks on check box for international price
    And user set international <price> for the course
    When user has enters <discounted percentage>
    Then <discounted price> should update
    When clicked on save changes
    Then user should gets a toast <message>

    Examples: 
      | price | discounted percentage | discounted price | message             |
      |  1000 |                    10 |              900 | Saved Successfully! |
      |  2500 |                    50 |             1250 | Saved Successfully! |
      |  2500 |                     0 |             2500 | Saved Successfully! |





  Scenario Outline: Verify user is able to enter discount percentage and discounted price should be updated in international price
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on pricing
    And user checks the toggle and makes it paid if it is free
    And user clicks on check box for international price
    And user set international <price> for the course
    When user has enters <discounted percentage>
    Then user should gets a toast <message>

    Examples: 
      | price | discounted percentage | message                           |
      |     0 |                    10 | Please enter International Course Price |
      |       |                    10 | Please enter International Course Price |

  Scenario Outline: Verify user is able to create a coupon code
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on pricing
    And user checks the toggle and makes it paid if it is free
    And user clicks on create a coupon
    When user input name, <discount>, <number of uses>, and  <date>
    When press on save changes
    When clicked on save changes
    Then user should gets a toast <message>

    Examples: 
      | discount | number of uses | date       | message             |
      |       10 |              2 | 23-08-2024 | Saved Successfully! |
      |      100 |              2 | 10-09-2024 | Saved Successfully! |


  Scenario Outline: Verify user is able to create a coupon code with invalid details
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on pricing
    And user checks the toggle and makes it paid if it is free
    And user clicks on create a coupon
    When user sets <name>, <discount>, <number of uses>, and  <date>
    When press on save changes
    Then user should gets a toast <message>

    Examples: 
      | name                                                                   | discount | number of uses | date       | message                                                     |
      | new2                                                                   |        0 |              2 | 08/15/2024 | Discount % can't be empty or zero                           |
      | New2                                                                   |       78 |              3 | 01/14/1996 | The expiration date cannot be earlier than the current date or be the current date |
      | New2                                                                   |      110 |              2 | 09/15/2024 | Discount % can't exceed 100                                 |
      |                                                                        |       20 |              2 | 08/15/2024 | Coupon code can't be empty                                  |
      | New2                                                                   |          |              2 | 12/15/2024 | Discount % can't be empty or zero                           |
      | New2                                                                   |       25 |                | 10/15/2024 | Number of uses can't be empty or zero                       |
      | new2                                                                   |       10 |              0 | 08/15/2024 | Number of uses can't be empty or zero                       |
      | New2                                                                   |       50 |              2 |            | Expiration date can't be empty                                 |
      | this is new coupon code for testing the length of the coupon code name |       10 |              2 | 08/15/2024 | Coupon code can't exceed 15 characters!                     |	


  Scenario Outline: Verify user is able to create a coupon code with invalid details
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on pricing
    And user checks the toggle and makes it paid if it is free
    And user clicks on create a coupon
    When user  enters already existing couponcode name, <discount>, <number of uses>, and   <date>
    When press on save changes
    Then user should gets a toast <message>

    Examples: 
      | discount | number of uses | date       | message                     |
      |       10 |              2 | 08/22/2024 | Coupon Name already exists! |

  Scenario Outline: Verify user is able to edit a coupon code
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on pricing
    And user checks the toggle and makes it paid if it is free
    And user clicks on edit option
    And user removes the details
    When user input name, <discount>, <number of uses>, and  <date>
    When press on save changes
    When clicked on save changes
    Then user should gets a toast <message>

    Examples: 
      | discount | number of uses | date       | message             |
      |       10 |              2 | 08/15/2024 | Saved Successfully! |
      |      100 |              2 | 10/15/2024 | Saved Successfully! |

  Scenario Outline: Verify user is able to edit a coupon code with invalid details
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on pricing
    And user checks the toggle and makes it paid if it is free
    And user clicks on edit option
    And user removes the details
    When user inputs fields for <name>, <discount>, <number of uses>, and  <date>
    When press on save changes
    Then user should gets a toast <message>

    Examples: 
      | name                                                                   | discount | number of uses | date       | message                                                     |
      | new2                                                                   |        0 |              2 | 10/15/2024 | Discount % can't be empty or zero                           |
      |                                                                        |          |                |            | Coupon code can't be empty                                  |
      | New4                                                                   |       78 |              3 | 08/15/1996 | The expiration date cannot be earlier than the current date |
      | New2                                                                   |      110 |              2 | 11/15/2024 | Discount % can't exceed 100                                 |
      |                                                                        |       20 |              2 | 08/15/2024 | Coupon code can't be empty                                  |
      | New2                                                                   |          |              2 | 12/15/2024 | Discount % can't be empty or zero                           |
      | New2                                                                   |       25 |                | 09/15/2024 | Number of uses can't be empty or zero                       |
      | new2                                                                   |       10 |              0 | 08/15/2024 | Number of uses can't be empty or zero                       |
      | New2                                                                   |       50 |              2 |            | Expires date can't be empty                                 |
      | this is new coupon code for testing the length of the coupon code name |       10 |              2 | 08/15/2024 | Coupon code can't exceed 15 characters!                     |

  Scenario Outline: Verify user is able to edit a coupon code with invalid details
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on pricing
    And user checks the toggle and makes it paid if it is free
    And user clicks on edit option
    And user removes the details
    When user  enters already existing couponcode name, <discount>, <number of uses>, and   <date>
    When press on save changes
    Then user should gets a toast <message>

    Examples: 
      | discount | number of uses | date       | message                     |
      |       10 |              2 | 08/15/2024 | Coupon Name already exists! |

  Scenario Outline: Verify user is able to create a referral code
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on pricing
    And user clicks configure referral code
    And user removed the details
    When user provides <discount>, <number of uses>, <cash back>
    When press on save changes
    Then user should gets a toast <message>
    And user checks the toggle for referral and makes it active if it is inactive
    When clicked on save changes
    Then user should gets a toast <message1>

    Examples: 
      | discount | number of uses | cash back | message                 | message1            |
      |       20 |              2 |        10 | Referral Coupon Created | Saved Successfully! |
      |       50 |              3 |        35 | Referral Coupon Created | Saved Successfully! |
      |       50 |              3 |         0 | Referral Coupon Created | Saved Successfully! |
      |      100 |              3 |        50 | Referral Coupon Created | Saved Successfully! |

  Scenario Outline: Verify user is able to edit a referral code
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on pricing
    And user checks the toggle for referral and makes it active if it is inactive
    And user clicks configure referral code
    And user removed the details
    When user provides <discount>, <number of uses>, <cash back>
    When press on save changes
    Then user should gets a toast <message>

    Examples: 
      | discount | number of uses | cash back | message                                        |
      |      200 |              2 |        10 | Referrals discount can't exceed 100            |
      |          |              2 |        10 | Referrals discount code can't be empty or zero |
      |        0 |              2 |        10 | Referrals discount code can't be empty or zero |
      |       50 |                |        35 | Number of uses can't be empty or zero          |
      |       50 |              0 |        35 | Number of uses can't be empty or zero          |
      |       35 |              3 |           | Cashback given can't be empty                  |
      |          |                |           | Referrals discount code can't be empty or zero |

  Scenario Outline: Verify user is able to save the course details page with valid data
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    When user clicks on course details page
    And user delete the fields
    And user write <course details>, <Benefits>, and <requirements>
    And user writes <instructor name>,  <description>, and <instructor image>
    When clicked on save changes
    Then user should gets a toast <message>

    Examples: 
      | course details                                                                        | Benefits                                                                           | requirements                                          | instructor name                                                                                                                      | description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  | instructor image                       | message                                             |
      | The curriculum also includes advanced topics such as API testing, performance testing | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques." | Basic understanding of software development processes | John Doe                                                                                                                             | Senior Software Testing Engineer with 10+ Years of Experience                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                | C:\\Users\\DELL\\Downloads\\flower.jpg | Saved Successfully!                                 |
      |                                                                                       | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques." | Basic understanding of software development processes | John Doe                                                                                                                             | Senior Software Testing Engineer with 10+ Years of Experience                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                | C:\\Users\\DELL\\Downloads\\flower.jpg | Course Details can't be empty!                      |
      | The curriculum also includes advanced topics such as API testing, performance testing |                                                                                    | Basic understanding of software development processes | John Doe                                                                                                                             | Senior Software Testing Engineer with 10+ Years of Experience                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                | C:\\Users\\DELL\\Downloads\\flower.jpg | Saved Successfully!                                 |
      | The curriculum also includes advanced topics such as API testing, performance testing | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques." |                                                       | John Doe                                                                                                                             | Senior Software Testing Engineer with 10+ Years of Experience                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                | C:\\Users\\DELL\\Downloads\\flower.jpg | Course Requirements can't be empty!                 |
      | The curriculum also includes advanced topics such as API testing, performance testing | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques." | Basic understanding of software development processes |                                                                                                                                      | Senior Software Testing Engineer with 10+ Years of Experience                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                | C:\\Users\\DELL\\Downloads\\flower.jpg | Instructor Name can't be empty!                     |
      | The curriculum also includes advanced topics such as API testing, performance testing | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques." | Basic understanding of software development processes | John Doe                                                                                                                             |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              | C:\\Users\\DELL\\Downloads\\flower.jpg | Instructor Details can't be empty!                  |
      | The curriculum also includes advanced topics such as API testing, performance testing | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques." | Basic understanding of software development processes | John Doe                                                                                                                             | John Doe is a seasoned software testing engineer with over a decade of experience in the industry. He has worked with various multinational companies, leading testing teams and implementing robust testing strategies. John specializes in both manual and automated testing, and has a deep understanding of tools such as Selenium, TestNG, JIRA, and Postman. His teaching approach is practical and hands-on, ensuring that participants not only learn theoretical concepts but also gain valuable practical experience. John is passionate about sharing his knowledge and helping others succeed in their software testing careers. | C:\\Users\\DELL\\Downloads\\flower.jpg | Instructor Description can't exceed 300 characters! |
      | The curriculum also includes advanced topics such as API testing, performance testing | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques." | Basic understanding of software development processes | John Doe Senior Software Testing Engineer with 10+ Years of Experience Senior Software Testing Engineer with 10+ Years of Experience | Senior Software Testing Engineer with 10+ Years of Experience                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                | C:\\Users\\DELL\\Downloads\\flower.jpg | Instructor Name can't exceed 100 characters!        |

  Scenario Outline: Verify user is able to save the course details page with invalid image
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    When user clicks on course details page
    And user delete the fields
    And user write <course details>, <Benefits>, and <requirements>
    And user writes <instructor name>,  <description>, and <instructor image>
    Then user should gets a toast <message>

    Examples: 
      | course details                                                                        | Benefits                                                                           | requirements                                          | instructor name | description                                                   | instructor image                                           | message                            |
      | The curriculum also includes advanced topics such as API testing, performance testing | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques." | Basic understanding of software development processes | John Doe        | Senior Software Testing Engineer with 10+ Years of Experience | C:\\Users\\Dell\\Downloads\\pexels-zhang-kaiyv-1138369.jpg | Image size should be less than 5MB |

  Scenario Outline: Verify user is able to save the module details page with valid details
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    When user clicks on course details page
    And user clicks on Add module
    When input <name>, <description>
    When user inputs <duration> and <order>
    When press on save changes
    When clicked on save changes
    Then user should gets a toast <message>

    Examples: 
      | name    | description                                                                        | duration | order | message             |
      | module  | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques." |       30 |     1 | Saved Successfully! |
      | module1 |                                                                                    |       30 |     1 | Saved Successfully! |
      | module2 | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques." |          |     1 | Saved Successfully! |
      | module3 |                                                                                    |          |     1 | Saved Successfully! |

  Scenario Outline: Verify user is able to save the module details page with invalid details
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    When user clicks on course details page
    And user clicks on Add module
    When input <name>, <description>
    When user inputs <duration> and <order>
    When press on save changes
    Then user should gets a toast <message>

    Examples: 
      | name   | description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               | duration | order | message                                         |
      |        | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |       30 |     1 | Module name can't be empty!                     |
      | module | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |       30 |       | Please specify the order of the module!         |
      |        | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |       30 |       | Module name can't be empty!                     |
      | module | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."    Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."    Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."    Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques." |       30 |     1 | Module description can't exceed 300 characters! |
      |        |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |          |       | Module name can't be empty!                     |
      |        |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |          |       | Module name can't be empty!                     |

  Scenario Outline: Verify user is able to edit the module details page with valid details
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    When user clicks on course details page
    And user clicks on edit module
    And clears the details
    When input <name>, <description>
    When user inputs <duration> and <order>
    When press on save changes
    When clicked on save changes
    Then user should gets a toast <message>

    Examples: 
      | name           | description                                                                        | duration | order | message             |
      | edited module  | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques." |       30 |     1 | Saved Successfully! |
      | edited module1 |                                                                                    |       30 |     2 | Saved Successfully! |
      | edited module2 | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques." |          |     4 | Saved Successfully! |
      | edited module3 |                                                                                    |          |     6 | Saved Successfully! |

  Scenario Outline: Verify user is able to add the module details page with invalid details
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    When user clicks on course details page
    And user clicks on edit module
    And clears the details
    When input <name>, <description>
    When user inputs <duration> and <order>
    When press on save changes
    Then user should gets a toast <message>

    Examples: 
      | name                                                        | description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               | duration | order | message                                         |
      |                                                             | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |       30 |     1 | Module name can't be empty!                     |
      | module                                                      | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |       30 |       | Plese specify the order of the module!          |
      |                                                             | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |       30 |       | Module name can't be empty!                     |
      | module                                                      | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."    Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."    Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."    Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."   Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques." |       30 |     1 | Module description can't exceed 300 characters! |
      |                                                             |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |          |       | Module name can't be empty!                     |
      |                                                             |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |          |       | Module name can't be empty!                     |
      | Advanced Data Structures and Algorithms for Complex Systems | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |       30 |     1 | Module name can't exceed 50 characters!         |
      | module                                                      | Welcome to "Mastering Software Testing: From Fundamentals to Advanced Techniques."                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |       30 |     0 | Please specify the correct order of the module! |

  Scenario Outline: Verify user is able to delete a module
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    When user clicks on course details page
    When user clicks on delete for a module
    Then user should gets a toast <message>

    Examples: 
      | message         |
      | Module Deleted! |

  Scenario Outline: Verify user is able to save batch details with valid and invalid data
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on Batch details
    And removes the fields if already filled
    And user is providing <start date>, <start time>, <no of classes>, <no of students>, <duration of course>
    And selects <starting class link>, <softstop>, <hardstop>
    When clicked on save changes
    Then user should gets a toast <message>

    Examples: 
      | start date | start time | no of classes | no of students | duration of course | starting class link | softstop | hardstop | message                                      |
      | 08/07/2024 | 11:00AM    |             5 |             10 |                  3 | no                  | no       | yes      | Saved Successfully!                          |
      | 08/07/2024 | 11:00AM    |             5 |                |                  3 | no                  | no       | yes      | Number of students per batch can't be empty! |
      | 08/07/2024 | 11:00AM    |             0 |              5 |                  3 | no                  | no       | yes      | Number of classes can't be zero!             |
      | 08/07/2024 | 11:00AM    |             0 |              5 |                    | no                  | no       | yes      | Duration of course can't be empty!           |
      | 08/07/2024 | 11:00AM    |             5 |             10 |                  3 | no                  | no       | yes      | Saved Successfully!                          |
      | 07/26/1996 | 11:00AM    |             5 |             10 |                  3 | yes                 | yes      | no       | Course Start date can't be before tomorrow!  |
      |            | 11:00AM    |             5 |             10 |                  3 | yes                 | yes      | no       | Course start date can't be empty!            |
      |            | 12:00PM    |               |                |                    | no                  | no       | yes      | Course start date can't be empty!            |

  Scenario Outline: Verify extend option for batch details
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on Batch details
    And removes the fields if already filled
    And user is providing <start date>, <start time>, <no of classes>, <no of students>, <duration of course>
    And selects <starting class link>, <softstop>, <hardstop>
    When clicked on save changes
    Then user should gets a toast <message>
    And if course is inactive then make active
    When user clicks on course
    And current date is equal to start date
    Then extends option should be available

    Examples: 
      | start date | start time | no of classes | no of students | duration of course | starting class link | softstop | hardstop | message             |
      | 08/07/2024 | 11:00PM    |             5 |             10 |                  3 | no                  | yes      | no       | Saved Successfully! |

  #Verify course gets inactive after user clicks on extend
  #Verify Course start date and other details are filled when user clicks on extend
  #Verify user gets notification when he is navigated to batch details after clicking on extend
  #Verify user is Navigated to batch details when clicked on extend
  #Verify extend option is available when course start date is reached
  Scenario Outline: Verify extend option for batch details
    Given user is on course page
    When user clicks on extend
    Then user should gets a toast <message1>
    Then user should be navigated to batch details page
    Then expect course start date all the other details should be filled
    Then course should be inactive
    And removes the fields if already filled
    And user is providing <start date>, <start time>, <no of classes>, <no of students>, <duration of course>
    And selects <starting class link>, <softstop>, <hardstop>
    When clicked on save changes
    Then user should gets a toast <message2>
    And if course is inactive then make active

    Examples: 
      | start date | start time | no of classes | no of students | duration of course | starting class link | softstop | hardstop | message1                                       | message2            |
      | 08/07/2024 | 11:00PM    |             5 |              2 |                  3 | no                  | yes      | no       | Please select a new start date for your batch! | Saved Successfully! |

  Scenario Outline: verify user is end ongoing batch is dispalyed when class date has reached
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on Batch details
    Given user is on the web site page
    And user clicks on visit website
    Then user should be navigated to his website
    When user clicks on enroll now on landing page
    Then user will navigate to <course page>
    And user clicks on enroll now on course page

    # And books the seats one less than number of students per batch times
    Examples: 
      | course page |
      | Testing     |

  @skip
  Scenario Outline: verify user is end ongoing batch is dispalyed when class date has reached
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on Batch details
    And removes the fields if already filled
    And user is providing <start date>, <start time>, <no of classes>, <no of students>, <duration of course>
    And selects <starting class link>, <softstop>, <hardstop>
    When clicked on save changes
    Then user should gets a toast <message2>
    And if course is inactive then make active
    When user clicks on course
    Then course should be <active>
    Given user is on the web site page
    And user clicks on visit website
    Then user should be navigated to his website
    When user clicks on enroll now on landing page
    Then user will navigate to <course page>
    And user clicks on enroll now on course page
    And books the seats one number of students per batch times
    And user returns to creator dashboard
    Given user is on course page
    When user clicks on configure course
    And user clicks on Batch details
    And if soft stop selected
    Given user is on course page
    And if current Enrollments is equal to or greater than number of students per batch
    Then batch filled should displayed
    Then Paused is displayed

    Examples: 
      | start date | start time | no of classes | no of students | duration of course | starting class link | softstop | hardstop | message2            | active        | course page | fullname | email                    | mobile number | message                                   |
      | 07/28/2024 | 11:00AM    |             5 |              5 |                  3 | no                  | yes      | no       | Saved Successfully! | Active Course | Testing     | sudeshna | sudeshnashetty@gmail.com |    9133690791 | Your Seat for the course has been Booked! |

  @skip
  Scenario Outline: Verify end of ongoing batch is displayed when class date has reached and enrollments are updated accordingly
    Given user is on course page
    When user clicks on configure course
    Then user should be navigated to course configuration
    And user clicks on Batch details
    And if soft stop is selected
    Given user is on course page
    When user books <number_of_students> students for the course
    Then if current enrollments are zero
    Then the course should display "Course Active"
    When current enrollments are equal to or greater than <number_of_students> per batch
    Then "Batch Filled" should be displayed along with the "Pause" option
