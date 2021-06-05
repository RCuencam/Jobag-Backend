Feature: Register a new Employeer

  Scenario Outline: As a user i want to sign up as a employeer with a not used phone number.

    Given I can sign up as a employeer
    And I sending employeer to be created with employeer <id>
    Then I should be able to see my newly created employeer
    Examples:
      | id |
      | 1  |

  Scenario Outline: As a Employeer i want to see a error if the number is in use.

    Given I am in the register seccion
    And register a repeated number
    Then I should see a error message <error>
    Examples:
      |error                     |
      |"El numero ya esta en uso"|