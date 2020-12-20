Feature: This feature is used test get/update/create/delete JIRA projects API

  Scenario: get JIRA project by Key
    Given  We build JIRA API Get Request
    When  We send get Request to get JIRA project by "RAF"
    Then  "key" in response body is "RAF"

  Scenario: get JIRA project by ID
    Given  We build JIRA API Get Request
    When  We send get Request to get JIRA project by "10027"
    Then  "id" in response body is "10027"

  Scenario Outline: create Project
    Given We build JIRA API POST Request
    When Project Payload is created for key "<key>" and Description "<description>"
    And  We send post Request  to JIRA
    Then "key" in response body is "<key>"
    Examples:
      |key  |descritpion|
    |  TP1   |     Test Description1      |

  Scenario: delete Project
    Given We build JIRA API Get Request
    When  We send delete Request to JIRA to delete "TP1"
    Then assert status code is 204