Feature: As a Postulant I want to see my possible payment plans

  Scenario Outline: As a postulant i want to access to my active payment plans
    Given I am in the plan section
    And I want to access to the plan with plan
    Then I want to see the plan with plan description <description>,posts <postulations>, video <video_duration> and duration <duration>
    Examples:
      | description                  | postulations  | video_duration      | duration |
      |      "plan_unlimited"        |    3          |       5             |  30      |

  Scenario Outline: As a postulant i want to have 2 active payment plans
    Given I am in the plan section
    And I want to have more than one active payment plan
    Then I should see a plan error message <plan_error>
    Examples:
      | plan_error |
      |  "Solo puedes tener un plan activo" |