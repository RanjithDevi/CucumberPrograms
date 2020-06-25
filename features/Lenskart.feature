Feature: Lenskart Testcase
Scenario: Online Shopping
Given Goto https://www.lenskart.com/
And Mouseover on Contact Lenses 
And Click on Monthly under Explore By Disposability
And Select brand as Aqualens
And Click on the first product
When Click Buy Now
Then Select No of boxes as 2 and Power as -1 for both eyes
And Type your name in User's name 
And And click Save and continue
And Print total amount and click Proceed to Checkout