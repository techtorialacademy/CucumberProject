Feature: Testing Login Functionality for SauceLab

  Scenario: Happy Path Login Functionality
    Given User navigates to the 'https://www.saucedemo.com/'
    When User provides 'standard_user' and 'secret_sauce' to the SauceLoginPage
    Then User validates the 'Swag Labs' from SauceMainPage

  #CONVERT FROM SCENARIO TO SCENARIO OUTLINE

  Scenario Outline: Happy Path Login Functionality with Scenario Outline
    Given User navigates to the '<url>'
    When User provides '<username>' and '<password>' to the SauceLoginPage
    Then User validates the '<title>' from SauceMainPage
    Examples:
      | url                        | username                | password     | title     |
      | https://www.saucedemo.com/ | standard_user           | secret_sauce | Swag Labs |
      | https://www.saucedemo.com/ | problem_user            | secret_sauce | Swag Labs |
      | https://www.saucedemo.com/ | performance_glitch_user | secret_sauce | Swag Labs |
      | https://www.saucedemo.com/ | error_user              | secret_sauce | Swag Labs |
      | https://www.saucedemo.com/ | visual_user             | secret_sauce | Swag Labs |






