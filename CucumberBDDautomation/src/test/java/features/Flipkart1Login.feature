Feature: Login into the Flipkart ecommerce site

Scenario Outline: Validating Login functionality with valid ceredentails
Given Initialize the browser with chrome
And Navigate to "https://www.flipkart.com/" site
When User enters <username> and <password> and login
Then Verify that user is successfully logged in


Examples:
|username  |password|
|8447704863|Fl1pk@rt|



