@regression
Feature: Testing Adding Product Functionality in Techtorial Website

  Background: Repetitive Step
    Given User provides username and password to the Sign In box

  Scenario: Happy Path Product Addition Functionality
    When User clicks Product Button on the left side and AddProductButton from ProductPage
    And User provides 'Truck-Mounted Crane' and '15000' to the product details box
    And User selects 'Lifting and Material Handling Equipment','Mobile Cranes' and '1' from drop-downs
    And User clicks purchase check box and add 'It is a good product' into the description.
    Then User validates product details 'Truck-Mounted Crane','$16,500.00','Allowed' from table

  @smoke
  Scenario Outline: Happy Path Product Filter Functionality   (COMMAND + OPTION +L)
    When User clicks Products button
    And User selects '<category>' and '<subCategory>' for categories
    And User clicks three dots and view button for Product Page
    Then User validates '<category>' and '<subCategory>' from action view
    Examples:
      | category                                | subCategory           |
      | Lifting and Material Handling Equipment | Mobile Cranes         |
      | Concrete and Paving Equipment           | Standard Mixer Trucks |
      | Concrete and Paving Equipment           | Volumetric Mixer Trucks |
      | Concrete and Paving Equipment           | Wheeled Asphalt Pavers |

#  Scenario: Happy Path Product Filter Functionality 2
#    When User clicks Products button
#    And User selects 'Concrete and Paving Equipment' and 'Standard Mixer Trucks' for categories
#    And User clicks three dots and view button for Product Page
#    Then User validates 'Concrete and Paving Equipment' and 'Standard Mixer Trucks' from action view
#
#  Scenario: Happy Path Product Filter Functionality 3
#    When User clicks Products button
#    And User selects 'Concrete and Paving Equipment' and 'Volumetric Mixer Trucks' for categories
#    And User clicks three dots and view button for Product Page
#    Then User validates 'Concrete and Paving Equipment' and 'Volumetric Mixer Trucks' from action view
#
#  Scenario: Happy Path Product Filter Functionality 4
#    When User clicks Products button
#    And User selects 'Concrete and Paving Equipment' and 'Wheeled Asphalt Pavers' for categories
#    And User clicks three dots and view button for Product Page
#    Then User validates 'Concrete and Paving Equipment' and 'Wheeled Asphalt Pavers' from action view


