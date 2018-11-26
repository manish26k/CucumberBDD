Feature: Search into the Flipkart ecommerce site

#Background:
#Then Verify that user is successfully logged in

Scenario: Get the tool tip text from the Search text box
Then Verify that user is successfully logged in
Then Verify tool tip text from search box

Scenario: Select any random product from the Search Suggestion list
When enter text in the search box then select randomly from the suggestion list
Then Verify Price is displayed and select the price from dropdown
And Verify Brand is displayed checkbox selected and click on the product
And if link open in the new tab
And check Size is present and click on addtocart or else click addtocart only
And again user navigate to the "https://www.flipkart.com/" site
