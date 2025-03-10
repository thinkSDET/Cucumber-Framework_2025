Feature: Place an order

  @Smoke
  Scenario: using default payment option
    * Launch the application as guest user
    * Navigate to the store page
    * Add the product from the store page
      | Anchor Bracelet |
    * Navigate to cart page
    * Navigate to checkout page
    * Fill the my billing details page
      | firstname | lastname | country  | streetAddress     | town/city | state  | pinCode | email             |
      | testing   | testing  | Bulgaria | 6300 Spring Creek | Alwar     | Vratsa | 75024   | test123@gmail.com |
    * Navigate to order page by placing the order from billing details page
    * Verify the order details on order page
      | productName     | subtotal | paymentMethod        |
      | Anchor Bracelet | $10.00   | Direct bank transfer |