#you can manually format your feature files using IntelliJ’s built-in Reformat Code feature:
# Open the .feature file.
# Press Ctrl + Alt + L (Windows/Linux)
#
Feature: Add to cart

  Scenario: Add one quantity from Store
    * Launch the application with valid credentials
    * Navigate to the store page
    * Add the product from the store page
      | Basic Blue Jeans |
    * Navigate to cart page
    * Verify that user can find the added product in cart page
      | Product         | Quantity |
      | Basic Blue Jeans | 1        |
