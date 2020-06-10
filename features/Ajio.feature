Feature: Ajio Testcase
Scenario: Online Shoping 
Given Go to https://www.ajio.com
And Mouseover on Women, CATEGORIES and click on Kurtas
And Click on Brands and choose Ajio
And Check all the results are Ajio
And Set Sort by the result as Discount
When Select the Color and click ADD TO BAG 
Then Verify the error message Select your size to know your estimated delivery date
And Select size and click ADD TO BAG 
And click on Enter pin-code to know estimated delivery date
And Print the message and click Go to  Bag 
And Click on Proceed to Shipping and close the browser