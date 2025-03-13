#you can manually format your feature files using IntelliJ’s built-in Reformat Code feature:
# Open the .feature file.
# Press Ctrl + Alt + L (Windows/Linux)
# Rules to write feature file -> do not expose anything which confidential and not related to scenarios [I mean events]
Feature: This feature file is validating the add to cart functionality.

  @Smoke
  Scenario: Add one quantity from Store
    * Launch the Zepto application with valid credentials
    * Navigate to the Store page
    * Add the product from the Store page
      | Basic Blue Jeans |
    * Navigate to Cart page
    * Verify that user can find the added product in Cart page
      | Product          | Quantity |
      | Basic Blue Jeans | 1        |
