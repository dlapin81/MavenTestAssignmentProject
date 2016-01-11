Feature: Search, sorting of the results, select product, verify that product topic contains given text  
   In order to verify following functionalies: search, sorting of the results, selecting of the product and verifying that product topic contains given text
   As a default user
   I should be able to verify that correct web content is shown based on the user actions

   Scenario: Open home page and search for Nikon keyword
   Given I open "http://www.amazon.com"
   When I enter "Nikon" in search textbox
   Then I should get page title and search result info bar updated as "Nikon"
   
   Scenario: Sort results by price from highest to lowest
   Given I select "Price: High to Low" from option menu
   Then I should get option menu "Price: High to Low" selected
   And I should get information bar updated to "Price: High to Low"
   
   @CloseBrowser
   Scenario: Select second product from the list and verify that product topic contains given text
   Given I select "second" product
   Then I should get product topic as "Nikon D3X"