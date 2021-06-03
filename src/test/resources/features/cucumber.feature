Feature: Post functionality

  Scenario Outline: As a customer i want to create a new skill.
    Given I can a new skill
    And I sending post to be created with post id <id>,name <name> and description <description>
    Then I should be able to see my newly created skill

    Examples:
    | id | name  | description  |
    | 1  | Maths | I learn Math |