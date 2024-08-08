@tag
Feature: Purchase the order from ecomerce website
  I want to use this template for my feature file
  Background:
	Given I landed on ecomerce page
  
  
 @Regression
  Scenario Outline: Positive Test of Subitting the order
    Given Login in with username <name> and password <password>
    When I add products <productName> from cart 
    And Checkout <productName> and submit the order 
    Then "Thankyou for the order." message is displayed on ConfirmationPage

    Examples: 
      | name       | password 		| productName |
      | h@hoai.com |  Thuhoai12@  |ZARA COAT 3  |
      
