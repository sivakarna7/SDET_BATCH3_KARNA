#Author: Pradeep Gopinath
#Created Date: 11/12/2021
#Description: SDET Assignment 17 related to Cucumber
#							17- Automate another cucumber scenario – 
#							Background: I am logged into Orange Application. 
#							Given- When I click on Admin Link 
#							Then-Click on Job 
#							AND- validate text – Job Title
@OragngHRP
Feature: SDET Cucumber Assignment

  Background: Login To Application
    Given Launch url
    When I am in OrangeHRP Application
    Then Login to Application

  @TC17_LoginToApplication
  Scenario: Login To Application
    Given I click on Admin Link
    Then Click on Job
    When validate text Job Title
    Then Close application