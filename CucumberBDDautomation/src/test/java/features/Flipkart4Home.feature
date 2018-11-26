Feature: Home Page functionality

Background:
Given user is on the "https://www.flipkart.com/" site

Scenario: Flipkart headerMenu
And mousehover on the menu item and click on any of the item
And again navigate back to the "https://www.flipkart.com/" site

Scenario: Flipkart Featured Brands
Then Verify the heading text is displayed or not
And click on the feature brand product
And again back to "https://www.flipkart.com/" site

Scenario: Flipkart RandomOffers
And click any random offer and add the product in the cart


