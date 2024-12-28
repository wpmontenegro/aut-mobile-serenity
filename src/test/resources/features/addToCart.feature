Feature: Shopping cart
  I as a DemoApp user
  Want to choose a product
  To add to shopping cart

  @ADD_TO_CART
  Scenario Outline: Choose product and add to cart
    Given I entry to product "<productName>"
    When I add it to the cart
    Then the product should be shown in the cart
    Examples:
      | productName         |
      | Sauce Labs Backpack |

  @DEEPLINK_TO_CART
  Scenario Outline: Choose product by DeepLink
    Given I load test data with a table
      | id   | amount   | color   | productName   |
      | <id> | <amount> | <color> | <productName> |
    When add a product to cart by deeplink
    Then the product should be shown in the cart
    Examples:
      | id | amount | color | productName       |
      | 5  | 3      | black | Sauce Labs Onesie |