@regressionWebOrder
Feature: Testing Product Order Functionality

  Scenario: Happy path Order functionality Normal
    Given User provides username,password and click order button
    When User enters the product information 'MyMoney' and '4'
    And User enters the address information 'Ahmet','2400 devos','Des Plaines','IL','60153'
    And User enters the payment information 'Visa','21312312321','11/25' and click process button
    Then User validates 'New order has been successfully added.'
    And User validates all the information 'Ahmet','MyMoney','4','2400 devos','Des Plaines','IL','60153','Visa','21312312321','11/25'

  Scenario Outline: Happy path Order functionality Scenario Outline
    Given User provides username,password and click order button
    When User enters the product information '<productName>' and '<quantity>'
    And User enters the address information '<name>','<street>','<city>','<state>','<zipCode>'
    And User enters the payment information '<cardType>','<cardNumber>','<expireDate>' and click process button
    Then User validates '<message>'
    And User validates all the information '<name>','<productName>','<quantity>','<street>','<city>','<state>','<zipCode>','<cardType>','<cardNumber>','<expireDate>'
    Examples:
      | productName | quantity | name             | street     | city        | state | zipCode | cardType         | cardNumber  | expireDate | message                                |
      | MyMoney     | 4        | Ahmet            | 2400 devos | Des Plaines | IL    | 60153   | Visa             | 21312312321 | 11/25      | New order has been successfully added. |
      | FamilyAlbum | 5        | AhmetAbdulCambar | 2400 devos | Des Plaines | IL    | 60153   | MasterCard       | 21312312322 | 11/26      | New order has been successfully added. |
      | ScreenSaver | 6        | Ay               | 2400 devos | Des Plaines | IL    | 60153   | American Express | 21312312323 | 11/27      | New order has been successfully added. |


  Scenario: Happy path Order functionality DataTable
    Given User provides username,password and click order button
    When User enters the product information
      | productName | MyMoney |
      | quantity    | 4       |
    And User enters the address information
      | name    | Ahmet       |
      | street  | 2400 devos' |
      | city    | Des Plaines |
      | state   | IL          |
      | zipCode | 60153       |
    And User enters the payment information and click process button
      | cardType   | Visa        |
      | cardNumber | 21312312321 |
      | expireDate | 11/25       |
    Then User validates message
      | New order has been successfully added. |
