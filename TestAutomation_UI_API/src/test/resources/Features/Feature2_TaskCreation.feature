Feature: feature to test task creation

  
  Scenario Outline: Verify Task Creation
    Given User clicks on Task sub menu
    When User select project <project> for task creation
    And User select taskType <taskType> for task  creation
    And User provided taskName <taskName>
    And User provided taskPriority <taskPriority>
    And User provided taskStatus <taskStatus>
    And User provided taskLabel <taskLabel>
    And User provided taskCreatedBy <taskCreatedBy>
    And User click on task save button
    Then I validate the task <task> from table

 Examples: 
      | project  | taskType | taskName  | taskPriority |taskStatus |taskLabel | taskCreatedBy | task |
      |Application dev for XYZ|Defects (Hourly rate $0.00)| DemoTask1 |Medum|Open|Task|admin|DemoTask1|

    