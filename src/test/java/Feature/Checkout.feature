Feature:Checkout Steps
  @checkout
  @product-detail
  Scenario: Adding products to the cart and emptying the cart
    Given a web browser is at home page
    And check if the homepage is opened
    And Click on the "Kadın" menu on the homepage
    And click on the "Ceketler" menu on the menu
    And size "S" is selected from the filters
    And Random product is selected
    And The loading of the product detail screen is controlled
    And A random size selection is made
    And Click add to cart
    And Basket Summary from the right side of the screen by clicking the My Cart button at the top right of the screen menu appears
    And Click go to cart
    And My basket is checked for loading the ramp
    And The product is removed from the basket with the help of the Delete button on the My Basket screen
    Then Check that the basket is empty
