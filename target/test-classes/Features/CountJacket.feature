#Author: info.rahil@yahoo.com
#Description : this feature file is to verify Men's Jacket and video feeds test cases
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
@Regression
Feature: Automating the Multiple NBA Test Cases
 

  @RegressionTest
  Scenario Outline: Get the details of mens jackets and put into Excel
    Given User is on NBA Warrior Home Page
    And some other precondition
    When User navigates to SHOP "<MainCategory>" section
    And further user navigates to "<SubCategory>" section
    And yet another action
    Then user has fetched the info like jacket title,jacket price and sellers headline
    And Store the info in excel
     
      Examples: 
      | MainCategory  | SubCategory    | status  |
      | Mens          |     Jacket     | success |
      | Mens          |     Jersey     | Fail    |
    

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

  