#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Data should be posted

  @tag1
  Scenario: client make call to post method
    Given provide the data <employeeId>,"<employeeName>"
    When client calls post method with /employeevo
    Then validate the response "<msg>"

    Examples: 
      | employeeId  | employeeName | msg  |
      | 9           |     akki     | success |
      
 