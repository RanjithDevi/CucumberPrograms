Feature: SheIn Testcase
Scenario: Online Shopping
Given Go https://www.shein.in
And Mouseover on Clothing and click Jeans
And Choose Black under Jeans product count
And Check size as medium
And Click + in color
And Check whether the color is black
And Click first item to Add to Bag 
When Click the size as M and click Submit
And Click View Bag 
And Check the size is Medium or not and close the browser