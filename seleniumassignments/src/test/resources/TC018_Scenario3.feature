
#Description: SDET Assignment 18 related to Cucumber
#							18- Create 4 scenarios and tag them with smoke and Regression, and run with cucumber
@OragngHRP
Feature: SDET Cucumber Assignment

  Background: 
    Given Launch url
    When I am in OrangeHRP Application
    Then Login to Application

  @SmokeTest
  Scenario: Default tab check
    Given User logged in successfully
    When Checking for default tab
    Then Close application

  @RegressionTest
  Scenario: Punch In check
    Given Getting into Attendance
    When Punching In
    When Validate success or failure
    Then Close application

  @RegressionTest
  Scenario: Punch Out check
    Given Getting into Attendance
    When Punching Out
    When Validate punched out or not
    Then Close application

  @RegressionTest
  Scenario: View Attendance Records
    Given Getting into Attendance
    When Getting into Employee Records
    When Searching for Employee Record
    Then Capture screenshot
    Then Close application
