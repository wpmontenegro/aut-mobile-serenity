Feature: Shopping cart
  I as a DemoApp user
  Want to choose a product
  To add to shopping cart

  @ADD_TO_CART
  Scenario Outline: Choose product and add to cart
    Given I entry to product "<product>"
    #When I add it to the cart
    #Then the product should be shown in the cart
    Examples:
      | product             |
      | Sauce Labs Backpack |