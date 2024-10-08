@smoke @regression
#Feature is a general description of what you are testing
Feature: Testing Login Functionality of Techtorial(Pizza)
  #Scenario is all about test cases(HappyPath,Negative..etc)

  Background: It is repeating steps for Loginpage
    Given User validates the title is 'techtorial' from LoginPage
    And User validates the log In is visible on the page

  Scenario: Happy Path Login Function (Slice of Pizza)
#    #Given is a precondition for the test case
#    Given User validates the title is 'techtorial' from LoginPage
#    #And is a continues precondition,action,results...
#    And User validates the log In is visible on the page
    #When is all about actions that you are doing
    When User provides username and password to the Sign In box
    #Then is all about results of your action
    Then User validates the title is 'Dashboard' from HomePage

    Scenario:Negative Path for Login Functionality(wrong username and wrong password)
#      Given User validates the title is 'techtorial' from LoginPage
#      And User validates the log In is visible on the page
      When User provides 'ahmet@example.com' and '2343' to the Sign In Box
      Then User validates 'These credentials do not match our records.' and color 'rgba(211, 0, 0, 1)' from loginPage





