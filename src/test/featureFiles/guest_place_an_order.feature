Feature: This feature file is verifying the place the orders.

 @smoke
  Scenario: using default payment option
    * Launch the Zepto application as guest user
    * Navigate to the Store page
    * Add the product from the Store page
      | Anchor Bracelet |
    * Navigate to Cart page
    * Navigate to Checkout page
    * Fill the my Billing details page
      | firstname | lastname | country  | streetAddress     | town/city | state  | pinCode | email             |
      | testing   | testing  | Bulgaria | 6300 Spring Creek | Alwar     | Vratsa | 75024   | test123@gmail.com |
    * Navigate to order page by placing the order from Billing details page
    * Verify the order details on Order page
      | productName     | subtotal | paymentMethod        |
      | Anchor Bracelets | $10.00   | Direct bank transfer |