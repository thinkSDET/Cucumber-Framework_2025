#you can manually format your feature files using IntelliJ’s built-in Reformat Code feature:
# Open the .feature file.
# Press Ctrl + Alt + L (Windows/Linux)
# Rules to write feature file -> do not expose anything which confidential and not related to scenarios [I mean events]
Feature: This feature file is validating the add to cart functionality.

  @Smoke
  Scenario: Add a single product from Store Page and verify that added product should be visible on Cart Page
    * Launch the Zepto application with valid credentials
    * Navigate to the Store page
    * Add the product from the Store page
      | Basic Blue Jeans |
    * Navigate to Cart page
    * Verify that user can find the added product in Cart page
      | Product          | Quantity |
      | Basic Blue Jeans | 1        |

 # this is scenario outline and we can pass the multiple data in this way as well
  @regression
  Scenario Outline: Add a <multiple product> from Men Page and verify that added product should be visible on Cart Page
    * Launch the Zepto application with valid credentials
    * Navigate to the Men page
    * Add the "<multiple product>" from the Men page
    * Navigate to Cart page
    * Verify that user can find the added product in Cart page
      | Product            | Quantity |
      | <multiple product> | 1        |

    Examples:
      | multiple product |
      | Red Shoes        |
      | Green Tshirt     |
      | Faint Blue Jeans |