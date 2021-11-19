
#Description: SDET Assignment 16 related to Cucumber
#							16- Automate below cucumber scenario -
#							Given- When I am in OrangeHRP Application
#							Then- Login to Application
#							When- Dashboard page is available
#							AND- click on Admin menu
@OragngHRP
Feature: SDET Cucumber Assignment

  @TC16_LoginToApplication
  Scenario: Login To Application
    Given Launch url
    When I am in OrangeHRP Application
    Then Login to Application
    When Dashboard page is available and click on Admin menu
    Then Close application