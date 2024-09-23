Feature: Test Web site section functionality

  Background: 
    Given user is on login page
    When user enters sudeshnashetty2211@gmail.com and CreatorX@123
    And user clicks on login
    Then user is navigated to the home page

  Scenario Outline: Verify user is able to make sections active and inactive
    Given user is on the web site page
    And user checks the status of <section>
    When user changed the <status> of <section>
    Given user is on home page
    Given user is on the web site page
    And user clicks on visit website
    Then <section> on the website should be <finalstate>

    Examples: 
      | section | status   | finalstate |
      | Gallery | Inactive | Absent     |
      | Closing | Inactive | Absent     |
  Scenario Outline: Verify user is able to make sections active and inactive
    Given user is on the web site page
    And user checks the status of <section>
    When user changes the <status> of <section>
    Then user should get a toast <message>

    Examples: 
      | section | status   | message                         |
      | Gallery | Active   | Gallery section is active now   |
      | Gallery | Inactive | Gallery section is deactive now |
      | Closing | Inactive | Closing section is deactive now |
      | Closing | Active   | Closing section is active now   |
      
  Scenario: Verify if the user is able to open Hero section
    Given user is on the web site page
    When user clicks on the Hero section
    Then the Hero section should be displayed

  Scenario: Verify delete option for the Hero  section
    Given user is on the web site page
    When user clicks on the Hero section
    Then delete section should not present

  Scenario Outline: Verify if the user is able to save changes with valid and invalid  details in the Hero section
    Given user is on the web site page
    When user clicks on the Hero section
    Then the Hero section should be displayed
    And user clears the fields
    When user typed <title>, <description> and uploads <Image>
    And clicks on save changes
    Then user should get a toast <message>

    Examples: 
      | title                                                                                        | description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             | Image                                                       | message                                  |
      | Hero Title 123 !@                                                                            | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Saved Successfully!                      |
      | Hero Title 123 !@ Embrace the challenge Title 123 !@  Embrace the challengeHero Title 123 !@ | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward!                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Title can't exceed 50 characters!        |
      | Hero Title 123 !@                                                                            | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Description can't exceed 200 characters! |
      |                                                                                              | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward!                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Title can't be empty!                    |
      | Hero Title 123 !@                                                                            |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Description can't be empty!              |

  Scenario Outline: Verify if the user is able to save changes with invalid thumb nail details in the Hero section
    Given user is on the web site page
    When user clicks on the Hero section
    Then the Hero section should be displayed
    And user clears the fields
    When user typed <title>, <description> and uploads <Image>
    Then user should get a toast <message>

    Examples: 
      | title             | description                                                                                                                                                                                           | Image                                                      | message                               |
      | Hero Title 123 !@ | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! | C:\\Users\\DELL\\Documents\\SkillTes.xlsx                  | File extension should be jpg/jpeg/png |
      | Hero Title 123 !@ | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! | C:\\Users\\DELL\\Downloads\\pexels-zhang-kaiyv-1138369.jpg | Image size should be less than 5MB    |

  Scenario Outline: Verify if user gets Error message when user leave thumb nail blank in hero section.
    Given user is on the web site page
    When user clicks on the Hero section
    Then the Hero section should be displayed
    And user clears the fields
    When user types <title>,  <description>
    And clicks on save changes
    Then user should get a toast <message>

    Examples: 
      | title             | description                                                                                                                                                                                           | message                                 |
      | Hero Title 123 !@ | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! | Please choose an image for Hero section |
      |                   |                                                                                                                                                                                                       | Title can't be empty!                   |

  Scenario Outline: Verify if user gets Error message when user leaves all details blank in hero section.
    Given user is on the web site page
    When user clicks on the Hero section
    Then the Hero section should be displayed
    And user clears the fields
    When User clicks on save changes
    Then user should get a toast <message>

    Examples: 
      | message               |
      | Title can't be empty! |

  Scenario: Verify if the user is able to open course section
    Given user is on the web site page
    When user clicks on the course section
    Then the course section should be displayed

  Scenario: Verify delete option for the course section
    Given user is on the web site page
    When user clicks on the course section
    Then delete section should not present

  Scenario Outline: Verify if the user is able to save changes for course section with valid and invalid details
    Given user is on the web site page
    When user clicks on the course section
    Then the course section should be displayed
    And user cleared the fields
    When user types <title>,  <description>
    And clicks on save changes
    Then user should get a toast <message>

    Examples: 
      | title                                                                                          | description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             | message                                  |
      | course Title 123 !@                                                                            | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 | Saved Successfully!                      |
      | course Title 123 !@ Embrace the challenge Title 123 !@  Embrace the challengeHero Title 123 !@ | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward!                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | Title can't exceed 50 characters!        |
      | course Title 123 !@                                                                            | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! | Description can't exceed 200 characters! |
      |                                                                                                | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 | Title can't be empty!                    |
      | course Title 123 !@                                                                            |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         | Description can't be empty!              |
      |                                                                                                |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         | Title can't be empty!                    |
      |                                                                                                |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         | Title can't be empty!                    |

  Scenario: Verify if the user is able to open Content section
    Given user is on the web site page
    When user clicks on the Content section
    Then the Content section should be displayed

  Scenario: Verify delete option for the content section
    Given user is on the web site page
    When user clicks on the Content section
    Then delete section should be present

  Scenario Outline: Verify if the user is able to save changes with valid details and invalid details in the Content section
    Given user is on the web site page
    When user clicks on the Content section
    Then the Content section should be displayed
    And user selects the orientation of the section <orientation>
    And user clears the fields
    When user typed <title>, <description> and uploads <Image>
    And clicks on save changes
    Then user should get a toast <message>

    Examples: 
      | orientation   | title                                                                                        | description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             | Image                                                       | message                                  |
      | Text on Right | Hero Title 123 !@                                                                            | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Saved Successfully!                      |
      | Text on Right | Hero Title 123 !@ Embrace the challenge Title 123 !@  Embrace the challengeHero Title 123 !@ | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward!                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Title can't exceed 50 characters!        |
      | Text on Right | Hero Title 123 !@                                                                            | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Description can't exceed 200 characters! |
      | Text on Right |                                                                                              | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward!                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Title can't be empty!                    |
      | Text on Right | Hero Title 123 !@                                                                            |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Description can't be empty!              |

  Scenario Outline: Verify if the user is able to save changes with invalid thumb nail details in the Content section
    Given user is on the web site page
    When user clicks on the Content section
    Then the Content section should be displayed
    And user selects the orientation of the section <orientation>
    And user clears the fields
    When user typed <title>, <description> and uploads <Image>
    Then user should get a toast <message>

    Examples: 
      | orientation   | title             | description                                                                                                                                                                                           | Image                                                  | message                               |
      | Text on Right | Hero Title 123 !@ | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! | C:\\Users\\DELL\\Documents\\SkillTes.xlsx              | File extension should be jpg/jpeg/png |
      | Text on Right | Hero Title 123 !@ | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! | C:\\Users\\Dell\\Downloads\\Sample-jpg-image-15mb.jpeg | Image size should be less than 5MB    |

  Scenario Outline: Verify if user gets Error message when user leave thumb nail blank in content section.
    Given user is on the web site page
    When user clicks on the Content section
    Then the Content section should be displayed
    And user selects the orientation of the section <orientation>
    And user clears the fields
    When user types <title>,  <description>
    And clicks on save changes
    Then user should get a toast <message>

    Examples: 
      | orientation   | title             | description                                                                                                                                                                                           | message                                                             |
      | Text on Right | Hero Title 123 !@ | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! | Please choose either an image or a youtube link for content section |
      | Text on Right |                   |                                                                                                                                                                                                       | Title can't be empty!                                               |

  Scenario Outline: Verify if user gets Error message when user leaves all details blank in content section.
    Given user is on the web site page
    When user clicks on the Content section
    Then the Content section should be displayed
    And user selects the orientation of the section <orientation>
    And user clears the fields
    When User clicks on save changes
    Then user should get a toast <message>

    Examples: 
      | orientation   | message               |
      | Text on Right | Title can't be empty! |

  Scenario: Verify if the user youtube link is disabled when image is uploaded
    Given user is on the web site page
    When user clicks on the Content section
    And if image is uploaded
    Then youtube link should be disabled

  Scenario: Verify if the user is able to open closing section
    Given user is on the web site page
    When user clicks on the closing section
    Then the closing section should be displayed

  Scenario: Verify delete option for the closing section
    Given user is on the web site page
    When user clicks on the closing section
    Then delete section should be present

  Scenario Outline: Verify if the user is able to save changes with valid details and invalid details in the closing section
    Given user is on the web site page
    When user clicks on the closing section
    Then the closing section should be displayed
    And user clears the fields
    When user typed <title>, <description> and uploads <Image>
    And clicks on save changes
    Then user should get a toast <message>

    Examples: 
      | title                                                                                           | description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             | Image                                                       | message                                  |
      | closing Title 123 !@                                                                            | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Saved Successfully!                      |
      | closing Title 123 !@ Embrace the challenge Title 123 !@  Embrace the challengeHero Title 123 !@ | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward!                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Title can't exceed 50 characters!        |
      | closing Title 123 !@                                                                            | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Description can't exceed 200 characters! |
      |                                                                                                 | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward!                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Title can't be empty!                    |
      | closing Title 123 !@                                                                            |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Description can't be empty!              |

  Scenario Outline: Verify if the user is able to save changes with invalid thumb nail details in the closing section
    Given user is on the web site page
    When user clicks on the closing section
    Then the closing section should be displayed
    And user clears the fields
    When user typed <title>, <description> and uploads <Image>
    Then user should get a toast <message>

    Examples: 
      | title                | description                                                                                                                                                                                           | Image                                                  | message                               |
      | closing Title 123 !@ | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! | C:\\Users\\DELL\\Documents\\SkillTes.xlsx              | File extension should be jpg/jpeg/png |
      | closing Title 123 !@ | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! | C:\\Users\\Dell\\Downloads\\Sample-jpg-image-15mb.jpeg | Image size should be less than 5MB    |

  Scenario Outline: Verify if user gets Error message when user leave thumb nail blank in closing section.
    Given user is on the web site page
    When user clicks on the closing section
    Then the closing section should be displayed
    And user clears the fields
    When user types <title>,  <description>
    And clicks on save changes
    Then user should get a toast <message>

    Examples: 
      | title                | description                                                                                                                                                                                           | message                                    |
      | closing Title 123 !@ | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! | Please choose an image for Closing section |
      |                      |                                                                                                                                                                                                       | Title can't be empty!                      |

  Scenario Outline: Verify if user gets Error message when user leaves all details blank in closing section.
    Given user is on the web site page
    When user clicks on the closing section
    Then the closing section should be displayed
    And user clears the fields
    When User clicks on save changes
    Then user should get a toast <message>

    Examples: 
      | message               |
      | Title can't be empty! |

  Scenario Outline: Verify if the user is able to delete content section
    Given user is on the web site page
    When user clicks on the Content section
    Then delete section should be present
    When the user selects the delete option
    Then a confirmation pop up should be displayed
    When the user confirms the deletion
    Then user should get a toast <message>

    Examples: 
      | message                    |
      | Content Section is deleted |

  Scenario Outline: Verify if the user is able to delete closing section
    Given user is on the web site page
    When user clicks on the closing section
    Then delete section should be present
    When the user selects the delete option
    Then a confirmation pop up should be displayed
    When the user confirms the deletion
    Then user should get a toast <message>

    Examples: 
      | message                    |
      | Closing Section is deleted |

  Scenario: Verify if the user is able to click on add new section without selecting the section
    Given user is on the web site page
    When user presses on add new section
    And user triggers add section button
    Then add section button should be disabled

  Scenario Outline: Verify if user gets Error message when user leaves all details blank while adding new section.
    Given user is on the web site page
    When user presses on add new section
    And selects from the drop down the <section>
    When user hits add section
    Then section form should be displayed
    Then save changes should be disabled

    Examples: 
      | section         |
      | Closing Section |
      | Content Section |

  Scenario Outline: Verify if the user is able to add new section with invalid thumb nail details in closing section
    Given user is on the web site page
    When user presses on add new section
    And selects from the drop down the <section>
    When user hits add section
    Then section form should be displayed
    When user typed <title>, <description> and uploads <Image>
    Then user should get a toast <message>

    Examples: 
      | section         | title                | description                                                                                                                                                                                           | Image                                                      | message                               |
      | Closing Section | closing Title 123 !@ | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! | ‪‪ ‪C:\\Users\\DELL\\Documents\\SkillTes.xlsx              | File extension should be jpg/jpeg/png |
      | Closing Section | closing Title 123 !@ | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! | C:\\Users\\Dell\\Downloads\\pexels-zhang-kaiyv-1138369.jpg | Image size should be less than 5MB    |

  Scenario Outline: Verify if user gets Error message when user leave thumb nail blank in closing section.
    Given user is on the web site page
    When user presses on add new section
    And selects from the drop down the <section>
    When user hits add section
    Then section form should be displayed
    When user types <title>,  <description>
    And clicks on save changes
    Then user should get a toast <message>

    Examples: 
      | section         | title                | description                                                                                                                                                                                           | message                                    |
      | Closing Section | closing Title 123 !@ | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! | Please choose an image for Closing section |

  Scenario Outline: Verify if the user is able to add new section with valid and invalid details in closing section
    Given user is on the web site page
    When user presses on add new section
    And selects from the drop down the <section>
    When user hits add section
    Then section form should be displayed
    When user typed <title>, <description> and uploads <Image>
    And clicks on save changes
    Then user should get a toast <message>

    Examples: 
      | section         | title                                                                                          | description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             | Image                                                       | message                                  |
      | Closing Section | closing Title 123 !@ Embrace the challenge Title 123 !@ Embrace the challengeHero Title 123 !@ | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward!                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Title can't exceed 50 characters!        |
      | Closing Section | closing Title 123 !@                                                                           | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Description can't exceed 200 characters! |
      | Closing Section |                                                                                                | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward!                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Title can't be empty!                    |
      | Closing Section | closing Title 123 !@                                                                           |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Description can't be empty!              |
      | Closing Section | closing Title 123 !@                                                                           | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Closing section added successfully       |

  Scenario Outline: Verify if the user is able to add new section with invalid thumb nail details in content section
    Given user is on the web site page
    When user presses on add new section
    And selects from the drop down the <section>
    When user hits add section
    Then section form should be displayed
    And user selects the orientation of the section <orientation>
    When user typed <title>, <description> and uploads <Image>
    Then user should get a toast <message>

    Examples: 
      | section         | orientation   | title                | description                                                                                                                                                                                           | Image                                                  | message                               |
      | Content Section | Text on Right | content Title 123 !@ | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! | C:\\Users\\DELL\\Documents\\SkillTes.xlsx              | File extension should be jpg/jpeg/png |
      | Content Section | Text on Right | content Title 123 !@ | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! | C:\\Users\\Dell\\Downloads\\Sample-jpg-image-15mb.jpeg | Image size should be less than 5MB    |

  Scenario Outline: Verify if user gets Error message when user leave thumb nail blank in content section.
    Given user is on the web site page
    When user presses on add new section
    And selects from the drop down the <section>
    When user hits add section
    Then section form should be displayed
    And user selects the orientation of the section <orientation>
    When user types <title>,  <description>
    And clicks on save changes
    Then user should get a toast <message>

    Examples: 
      | section         | orientation   | title                | description                                                                                                                                                                                           | message                                                             |
      | Content Section | Text on Right | content Title 123 !@ | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! | Please choose either an image or a youtube link for content section |

  Scenario Outline: Verify if the user is able to add new section with valid and invalid details for content section
    Given user is on the web site page
    When user presses on add new section
    And selects from the drop down the <section>
    When user hits add section
    Then section form should be displayed
    And user selects the orientation of the section <orientation>
    When user typed <title>, <description> and uploads <Image>
    And clicks on save changes
    Then user should get a toast <message>

    Examples: 
      | section         | orientation   | title                                                                                          | description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             | Image                                                       | message                                  |
      | Content Section | Text on Right | content Title 123 !@ Embrace the challenge Title 123 !@ Embrace the challengeHero Title 123 !@ | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward!                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Title can't exceed 50 characters!        |
      | Content Section | Text on Right | content Title 123 !@                                                                           | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Description can't exceed 200 characters! |
      | Content Section | Text on Right |                                                                                                | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward!                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Title can't be empty!                    |
      | Content Section | Text on Right | content Title 123 !@                                                                           |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Description can't be empty!              |
      | Content Section | Text on Right | content Title 123 !@                                                                           | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 | C:\\Users\\DELL\\Pictures\\screenshots\\Screenshot (27).png | Saved Successfully!                      |

  @skip
  Scenario: Verify if the user is able to open footer section
    Given user is on the web site page
    When user clicks on the footer section
    Then the footer section should be displayed

  Scenario: Verify delete option for the footer section
    Given user is on the web site page
    When user clicks on the footer section
    Then delete section should not present

  Scenario Outline: Verify if the user is able to save changes for footer section with valid and invalid details
    Given user is on the web site page
    When user clicks on the footer section
    Then the footer section should be displayed
    And user erases the fields
    When user has filled <Brand name>, <tagline>, <copyright>, <gram>, <Face book>, <you tube>, <twitter>, <linkedIn>
    And clicks on save changes
    Then user should get a toast <message>

    Examples: 
      | Brand name | tagline                                     | copyright                            | gram                                   | Face book                          | you tube                             | twitter                    | linkedIn                                 | message                              |
      | CreatorX   | Master Testing Skills for a Flawless Future | © 2024 Khambee. All rights reserved. | https://www.instagram.com/testuser123/ | https://www.facebook.com/testuser1 | https://www.youtube.com/@adityamusic | https://x.com/dummyprofile | https://www.linkedin.com/in/dummyprofile | Saved Successfully!                  |
      |            | Master Testing Skills for a Flawless Future | © 2024 Khambee. All rights reserved. | https://www.instagram.com/testuser123/ | https://www.facebook.com/testuser1 | https://www.youtube.com/@adityamusic | https://x.com/dummyprofile | https://www.linkedin.com/in/dummyprofile | Brand name can't be empty!           |
      | CreatorX   |                                             | © 2024 Khambee. All rights reserved. | https://www.instagram.com/testuser123/ | https://www.facebook.com/testuser1 | https://www.youtube.com/@adityamusic | https://x.com/dummyprofile | https://www.linkedin.com/in/dummyprofile | Saved Successfully!                  |
      | CreatorX   | Master Testing Skills for a Flawless Future |                                      | https://www.instagram.com/testuser123/ | https://www.facebook.com/testuser1 | https://www.youtube.com/@adityamusic | https://x.com/dummyprofile | https://www.linkedin.com/in/dummyprofile | Saved Successfully!                  |
      | CreatorX   | Master Testing Skills for a Flawless Future | © 2024 Khambee. All rights reserved. |                                        | https://www.facebook.com/testuser1 | https://www.youtube.com/@adityamusic | https://x.com/dummyprofile | https://www.linkedin.com/in/dummyprofile | Saved Successfully!                  |
      | CreatorX   | Master Testing Skills for a Flawless Future | © 2024 Khambee. All rights reserved. | https://www.instagram.com/testuser123/ |                                    | https://www.youtube.com/@adityamusic | https://x.com/dummyprofile | https://www.linkedin.com/in/dummyprofile | Saved Successfully!                  |
      | CreatorX   | Master Testing Skills for a Flawless Future | © 2024 Khambee. All rights reserved. | https://www.instagram.com/testuser123/ | https://www.facebook.com/testuser1 |                                      | https://x.com/dummyprofile | https://www.linkedin.com/in/dummyprofile | Saved Successfully!                  |
      | CreatorX   | Master Testing Skills for a Flawless Future | © 2024 Khambee. All rights reserved. | https://www.instagram.com/testuser123/ | https://www.facebook.com/testuser1 | https://www.youtube.com/@adityamusic |                            | https://www.linkedin.com/in/dummyprofile | Saved Successfully!                  |
      | CreatorX   | Master Testing Skills for a Flawless Future | © 2024 Khambee. All rights reserved. | https://www.instagram.com/testuser123/ | https://www.facebook.com/testuser1 | https://www.youtube.com/@adityamusic | https://x.com/dummyprofile |                                          | Saved Successfully!                  |
      | CreatorX   |                                             |                                      |                                        |                                    |                                      |                            |                                          | Saved Successfully!                  |
      |            |                                             |                                      |                                        |                                    |                                      |                            |                                          | Brand name can't be empty!           |
      | CreatorX   | Master Testing Skills for a Flawless Future | © 2024 Khambee. All rights reserved. | https:/.com/testuser123/               | https://www.facebook.com/testuser1 | https://www.youtube.com/@adityamusic | https://x.com/dummyprofile | https://www.linkedin.com/in/dummyprofile | Enter correct Instagram Profile link |
      | CreatorX   | Master Testing Skills for a Flawless Future | © 2024 Khambee. All rights reserved. | https://www.instagram.com/testuser123/ | https://www.facebook               | https://www.youtube.com/@adityamusic | https://x.com/dummyprofile | https://www.linkedin.com/in/dummyprofile | Enter correct Facebook Profile link  |
      | CreatorX   | Master Testing Skills for a Flawless Future | © 2024 Khambee. All rights reserved. | https://www.instagram.com/testuser123/ | https://www.facebook.com/testuser1 | dityamusic                           | https://x.com/dummyprofile | https://www.linkedin.com/in/dummyprofile | Enter correct YouTube Channel link   |
      | CreatorX   | Master Testing Skills for a Flawless Future | © 2024 Khambee. All rights reserved. | https://www.instagram.com/testuser123/ | https://www.facebook.com/testuser1 | https://www.youtube.com/@adityamusic | httdummyprofile            | https://www.linkedin.com/in/dummyprofile | Enter correct Twitter Profile link   |
      | CreatorX   | Master Testing Skills for a Flawless Future | © 2024 Khambee. All rights reserved. | https://www.instagram.com/testuser123/ | https://www.facebook.com/testuser1 | https://www.youtube.com/@adityamusic | https://x.com/dummyprofile | https:ummyprofile                        | Enter correct Linkedin Profile link  |

  Scenario Outline: Verify if the user is able to save changes for terms and conditions
    Given user is on the web site page
    When user clicks on the footer section
    Then the footer section should be displayed
    When user clicks to add terms and conditions
    And user clear terms and conditions if already filled
    And user defines his own <terms and condtions>
    When user clicks on AddTermsAndConditions
    Then user should get a toast <message>

    Examples: 
      | terms and condtions                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            | message                             |
      | Terms and Conditions Terms of Service General Terms By accessing and placing an order with The Product Platform, you confirm that you are in agreement with and bound by the terms of service contained in the Terms & Conditions outlined below. The Product Platform and you agree to these terms for the entire website and all electronic communications. Under no circumstances shall The Product Platform team be liable for any direct, indirect, special, incidental or consequential damages, including, but not limited to, loss of data or profit, arising out of the use, or the inability to use, the materials on this site, even if The Product Platform team or an authorised representative has been advised of the possibility of such damages. If your use of materials from this site results in the need for servicing, repair or correction of equipment or data, you assume any costs thereof. The Product Platform will not be responsible for any outcome that may occur during the course of usage of our resources. | Please save the changes too!        |
      |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                | Terms and Conditions can't be empty |

  Scenario Outline: Verify if the user is able to save changes for delivery and shipping policy
    Given user is on the web site page
    When user clicks on the footer section
    Then the footer section should be displayed
    When user clicks to add delivery and shipping policy
    And user clear deliver and shipping policy if already filled
    And user writes his own <delivery and shipping policy>
    When user clicks on AddDeliveryAndShippingPolicy
    Then user should get a toast <message>

    Examples: 
      | delivery and shipping policy                                                                                                                                                                                                                                                                                                                                                                                                                                       | message                                   |
      | Delivery and Shipping Policy: The Product Platform At The Product Platform, we are committed to providing a seamless and convenient learning experience for aspiring and seasoned product managers. As a digital platform offering learning, interview preparation, expert guidance, and quick learning solutions, we do not involve physical products, shipping, or delivery. Please review the following information regarding our delivery and shipping policy: | Please save the changes too!              |
      |                                                                                                                                                                                                                                                                                                                                                                                                                                                                    | Delivery & Shipping Policy can't be empty |

  Scenario Outline: Verify if the user is able to save changes for refund policy
    Given user is on the web site page
    When user clicks on the footer section
    Then the footer section should be displayed
    When user clicks to add refund policy
    And user clear refund policy if already filled
    And user defined his own <refund policy>
    When user clicks on AddRefundPolicy
    Then user should get a toast <message>

    Examples: 
      | refund policy                                                                                                                                                                                                                                                                                                                                                              | message                      |
      | We appreciate your participation at The Product Platform. Additionally, we want your experience to be positive while you research, evaluate, and buy our items. When ever you pay to sign up for one of our courses, full refunds are available until 7 days from the start of the respective course. No questions asked. After this period, no refunds will be available. | Please save the changes too! |
      |                                                                                                                                                                                                                                                                                                                                                                            | Refund Policy can't be empty |

  Scenario Outline: Verify if the user is able to save changes for privacy policy
    Given user is on the web site page
    When user clicks on the footer section
    Then the footer section should be displayed
    When user clicks to add privacy policy
    And user clear privacy policy if already filled
    And user creates his own <privacy policy>
    When user clicks on AddPrivacyPolicy
    Then user should get a toast <message>

    Examples: 
      | privacy policy                                                                                                                                                                                                                                                                 | message                       |
      | Privacy Policy & Terms At The Product Platform, accessible from theproductplatform.in, one of our main priorities is the privacy of our visitors. This Privacy Policy document contains types of information collected and recorded by The Product Platform and how we use it. | Please save the changes too!  |
      |                                                                                                                                                                                                                                                                                | Privacy Policy can't be empty |

  Scenario Outline: Verify if the user is able to save changes for pricing policy
    Given user is on the web site page
    When user clicks on the footer section
    Then the footer section should be displayed
    When user clicks to add pricing policy
    And user clear pricing policy if already filled
    And user created his own <pricing policy>
    When user clicks on AddPricingPolicy
    Then user should get a toast <message>

    Examples: 
      | pricing policy                                                                                                                                                                                                                                                                                                                                                                                                  | message                       |
      | Basic Plan - Interview Prep Starter : Features: Interview Preparation: Access to our interview preparation resources, including mock interviews, common interview questions, and behavioral interview coaching. Quick Learning Solutions: Access to concise lessons and frameworks for quick learning. Community Access: Engage in our community forums to connect with peers and learn from their experiences. | Please save the changes too!  |
      |                                                                                                                                                                                                                                                                                                                                                                                                                 | Pricing Policy can't be empty |

  Scenario Outline: Verify user is able to save the gallery section changes.
    Given user is on the web site page
    And user opens gallery section
    And user clear the fields if already filled
    When user redefines gallery <title>  <description> and uploads <no of images>,  <Image>
    And clicks on save changes for gallery section
    Then user should get a toast <message>

    Examples: 
      | title                                                                                                                   | description                                                                                                                                                                                                                                                                                                                                                                                        | no of images | Image                                                                                                                                                                                                                                               | message                                  |
      | Our Visual Showcase                                                                                                     | Welcome to our gallery! Here, you’ll find a curated selection of images that capture the essence of our work, values, and vision                                                                                                                                                                                                                                                                   |            2 | C:\\Users\\DELL\\Downloads\\image-58602add-77f5-4b0e-8f6a-92c6476824072024-08-27T14_02_06.406094156.jpg,C:\\Users\\DELL\\Downloads\\image-c06b5b44-7b9f-45aa-9d9b-c6fcde998e7c2024-08-23T09_57_22.164202819.jpg                                     | Saved Successfully!                      |
      | Our Visual Showcase                                                                                                     | Welcome to our gallery! Here, you’ll find a curated selection of images that capture the essence of our work, values, and vision                                                                                                                                                                                                                                                                   |            3 | C:\\Users\\DELL\\Downloads\\image-58602add-77f5-4b0e-8f6a-92c6476824072024-08-27T14_02_06.406094156.jpg,C:\\Users\\DELL\\Downloads\\image-c06b5b44-7b9f-45aa-9d9b-c6fcde998e7c2024-08-23T09_57_22.164202819.jpg,C:\\Users\\DELL\\Downloads\\cat.jpg | Saved Successfully!                      |
      |                                                                                                                         | Welcome to our gallery! Here, you’ll find a curated selection of images that capture the essence of our work, values, and vision                                                                                                                                                                                                                                                                   |            2 | C:\\Users\\DELL\\Downloads\\image-58602add-77f5-4b0e-8f6a-92c6476824072024-08-27T14_02_06.406094156.jpg,C:\\Users\\DELL\\Downloads\\image-c06b5b44-7b9f-45aa-9d9b-c6fcde998e7c2024-08-23T09_57_22.164202819.jpg                                     | Title can't be empty!                    |
      | Our Visual Showcase                                                                                                     |                                                                                                                                                                                                                                                                                                                                                                                                    |            2 | C:\\Users\\DELL\\Downloads\\image-58602add-77f5-4b0e-8f6a-92c6476824072024-08-27T14_02_06.406094156.jpg,C:\\Users\\DELL\\Downloads\\image-c06b5b44-7b9f-45aa-9d9b-c6fcde998e7c2024-08-23T09_57_22.164202819.jpg                                     | Description can't be empty!              |
      | Our Visual Showcase Our Visual Showcase Our Visual Showcase Our Visual Showcase Our Visual Showcase Our Visual Showcase | Welcome to our gallery! Here, you’ll find a curated selection of images that capture the essence of our work, values, and vision                                                                                                                                                                                                                                                                   |            2 | C:\\Users\\DELL\\Downloads\\image-58602add-77f5-4b0e-8f6a-92c6476824072024-08-27T14_02_06.406094156.jpg,C:\\Users\\DELL\\Downloads\\image-c06b5b44-7b9f-45aa-9d9b-c6fcde998e7c2024-08-23T09_57_22.164202819.jpg                                     | Title can't exceed 50 characters!        |
      | Our Visual Showcase                                                                                                     | Welcome to our gallery! Here, you’ll find a curated selection of images that capture the essence of our work, values, and vision Welcome to our gallery! Here, you’ll find a curated selection of images that capture the essence of our work, values, and vision Welcome to our gallery! Here, you’ll find a curated selection of images that capture the essence of our work, values, and vision |            2 | C:\\Users\\DELL\\Downloads\\image-58602add-77f5-4b0e-8f6a-92c6476824072024-08-27T14_02_06.406094156.jpg,C:\\Users\\DELL\\Downloads\\image-c06b5b44-7b9f-45aa-9d9b-c6fcde998e7c2024-08-23T09_57_22.164202819.jpg                                     | Description can't exceed 200 characters! |
      |                                                                                                                         |                                                                                                                                                                                                                                                                                                                                                                                                    |            2 | C:\\Users\\DELL\\Downloads\\image-58602add-77f5-4b0e-8f6a-92c6476824072024-08-27T14_02_06.406094156.jpg,C:\\Users\\DELL\\Downloads\\image-c06b5b44-7b9f-45aa-9d9b-c6fcde998e7c2024-08-23T09_57_22.164202819.jpg                                     | Title can't be empty!                    |

  Scenario Outline: Verify user is able to save the gallery section changes with invalid images.
    Given user is on the web site page
    And user opens gallery section
    And user clear the image field
    When user uploads invalid format of <Image>
    Then user should get a toast <message>

    Examples: 
      | Image                                                      | message                               |
      | C:\\Users\\DELL\\Documents\\SkillTes.xlsx                  | File extension should be jpg/jpeg/png |
      | C:\\Users\\DELL\\Downloads\\pexels-zhang-kaiyv-1138369.jpg | Image size should be less than 5MB    |

  Scenario Outline: Verify user is able to save the gallery section changes .
    Given user is on the web site page
    And user opens gallery section
    And user clear the fields if already filled
    When user redefined gallery <title>  <description>
    And clicks on save changes for gallery section
    Then user should get a toast <message>

    Examples: 
      | title               | description                                                                                                                      | message                                    |
      | Our Visual Showcase | Welcome to our gallery! Here, you’ll find a curated selection of images that capture the essence of our work, values, and vision | Please choose an image for gallery section |
      |                     |                                                                                                                                  | Title can't be empty!                      |

  Scenario Outline: Verify user is able to save the gallery section changes with already existing image.
    Given user is on the web site page
    And user opens gallery section
    And user clear the image field
    When user uploads exisiting image
    Then user should get a toast <message>

    Examples: 
      | message                      |
      | Failed to upload same image! |

  Scenario Outline: Verify if the user is able to save changes with valid and invalid  details in the call to action section
    Given user is on the web site page
    And user clicks on the call to action section
    And user clears the fields of call to action section
    When <title>, <description>, <call to action button Text>, <call to action link> are provided by user
    And clicks on save changes for section
    Then user should get a toast <message>

    Examples: 
      | title                                                                                                                                                                                                 | description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       | call to action button Text                                                                                                                                                                                                                                                                                                                                                                                  | call to action link            | message                                           |
      | Tpp                                                                                                                                                                                                   | The product platform for product manager                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          | Click here                                                                                                                                                                                                                                                                                                                                                                                                  | https://theproductplatform.in/ | Saved Successfully!                               |
      |                                                                                                                                                                                                       | The product platform for product manager                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          | Click here                                                                                                                                                                                                                                                                                                                                                                                                  | https://theproductplatform.in/ | Title can't be empty!                             |
      | Tpp                                                                                                                                                                                                   |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | Click here                                                                                                                                                                                                                                                                                                                                                                                                  | https://theproductplatform.in/ | Description can't be empty!                       |
      | Tpp                                                                                                                                                                                                   | The product platform for product manager                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |                                                                                                                                                                                                                                                                                                                                                                                                             | https://theproductplatform.in/ | Call To Action Button Text can't be empty!        |
      | Tpp                                                                                                                                                                                                   | The product platform for product manager                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          | Click here                                                                                                                                                                                                                                                                                                                                                                                                  |                                | Enter Correct Call To Action Button Link!         |
      | Tpp                                                                                                                                                                                                   | The product platform for product manager                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          | Click here                                                                                                                                                                                                                                                                                                                                                                                                  | theproductplatform.in          | Enter Correct Call To Action Button Link!         |
      | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! | The product platform for product manager                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          | Click here                                                                                                                                                                                                                                                                                                                                                                                                  | theproductplatform.in          | Title can't exceed 50 characters!                 |
      | The product platform for product manager                                                                                                                                                              | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! | Click here                                                                                                                                                                                                                                                                                                                                                                                                  | theproductplatform.in          | Description can't exceed 200 characters!          |
      | Tpp                                                                                                                                                                                                   | The product platform for product manager                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          | Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! Embrace the challenge seek new adventures and never stop learning. Growth comes from pushing boundaries and stepping outside your comfort zone. Your journey is the destination. Keep moving forward! | https://theproductplatform.in/ | Call To Action Button can't exceed 40 characters! |

  Scenario Outline: Verify if the user is able to save changes with valid image  details in the call to action section
    Given user is on the web site page
    And user clicks on the call to action section
    And clears image field if already uploaded
    When user tries to upload <image>
    And clicks on save changes for section
    Then user should get a toast <message>

    Examples: 
      | image                                                                                                   | message             |
      | C:\\Users\\DELL\\Downloads\\image-58602add-77f5-4b0e-8f6a-92c6476824072024-08-27T14_02_06.406094156.jpg | Saved Successfully! |

  Scenario Outline: Verify if the user is able to save changes with  invalid  image details in the call to action section
    Given user is on the web site page
    And user clicks on the call to action section
    And clears image field if already uploaded
    When user tries to upload <image>
    Then user should get a toast <message>

    Examples: 
      | image                                                      | message                               |
      | C:\\Users\\DELL\\Documents\\SkillTes.xlsx                  | File extension should be jpg/jpeg/png |
      | C:\\Users\\DELL\\Downloads\\pexels-zhang-kaiyv-1138369.jpg | Image size should be less than 5MB    |
      