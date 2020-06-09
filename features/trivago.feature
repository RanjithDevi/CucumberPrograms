Feature: Trivago Testcase
Scenario: Hotel booking 
Given Launch https://www.trivago.com
And Type Agra in Destination and select Agra, Uttar Pradesh
And Choose June 15 as check in and July 30 as check out
And Select Room as Family Room
And Choose Number of Adults 2, Childern 1 and set Child's Age as 4
And Click Confirm button and click Search
And Select Accommodation type as Hotels only and choose 4 stars
And Select Guest rating as Very Good
And Set Hotel Location as Agra Fort and click Done
When In more Filters, select Air conditioning, Restaurant and WiFi and click Done
And Sort the result as Rating & Recommended
Then Print the Hotel name, Rating, Number of Reviews and Click View Deal
And Print the URL of the Page
And Print the Price of the Room and click Choose Your Room 
And Click Reserve and I'll Reserve 
And Close the browser

