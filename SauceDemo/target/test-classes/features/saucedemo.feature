Feature: SauceDemo Login, Add to Cart, and Checkout Functions
  As a SauceDemo user
  I want to log in, add items to the cart, and complete a purchase
  So that I can successfully place an order

  Scenario: Successful Login and Checkout
    Given I log into the SauceDemo application with valid credentials
    When I add all available items to the shopping cart
    And I proceed to the checkout overview page
    And I enter valid contact details
    And I confirm my order details on the checkout review page
    Then I should be able to successfully complete the checkout
