Feature: Ebay shopping

@Portal
Scenario: Access a Product via category after applying multiple filters
    Given We are on ebay login page
    When I navigate to search in Cellphones and accessories
    Then Add filters appearing in the pop-up and then apply
    And Verify that filter tags are applied
    

@Portaltest
Scenario: Access a Product via search
    Given We are on ebay login page
    When We search a string in search bar
    And Change the search bar
    Then verify the page loads
    And Verify the search criteria
    
    