Feature: Login into Leaftaps application

Background:
Given User opens the Chrome browser
And User loads the production URL
And User maximizes the browser
And User sets the implicitly timeout

Scenario Outline: Positive flow for Create Lead[TC001]
Given User sets the username <username>  in loginpage
And User sets the password <password> in loginpage
When User clicks the login button in login page
Then User should be navigated to Leaftaps page
When User clicks the CRMSFA link in Leaftaps page
Then User should be able to navigate to MyHome page
When User clicks Leads link in MyHome page
Then User should be able to navigate to MyLeads page
When User clicks the Create Lead link in MyLeads page
Then Create Lead form should be opened in Create Lead page
Then User enters the company name <cName>
Then User enters the first name <fName>
Then User enters the last name <lName>
When User clicks the Create Lead button in CreateLead page
Then User should be navigated to View Lead page
Examples:
|username			|password|		cName			|	fName			|	lName		|	
|Demosalesmanager	|crmsfa	 |		IBM				|	Ponn			|	Oviyaa		|
|Democsr			|crmsfa	 |		CTS				|	Aakash			|	Mayilan		|
|Democsr			|crmsfa	 |		CTS				|	Saravana		|				|

Scenario Outline: Negative flow for Create Lead[TC001]
Given User sets the username <username>  in loginpage
And User sets the password <password> in loginpage
When User clicks the login button in login page
Then User should be navigated to Leaftaps page
When User clicks the CRMSFA link in Leaftaps page
Then User should be able to navigate to MyHome page
When User clicks Leads link in MyHome page
Then User should be able to navigate to MyLeads page
When User clicks the Create Lead link in MyLeads page
Then Create Lead form should be opened in Create Lead page
Then User enters the company name <cName>
Then User enters the last name <lName>
When User clicks the Create Lead button in CreateLead page
But Create Lead is failiure
