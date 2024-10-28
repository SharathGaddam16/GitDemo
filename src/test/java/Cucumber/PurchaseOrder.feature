
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file
  
  Background:
  Given I landed on Ecommerce Page
  
 
  @Regression
  Scenario Outline: Positive Test of submitting the order
    Given Logged in with UserName <name> and password <password>
    When I add product <productName>  to cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmationPage

    Examples: 
      | name               | password   | productName |
      | pandugad@gmail.com | Sharath@97 | ZARA COAT 3 |