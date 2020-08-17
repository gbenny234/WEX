Feature: Wex website search 
  I want to use this template for my feature file

  Scenario: Validate that Search functionality for Wex website is working as expected using valid(data expected to return data results) data.
    Given I lunch "firefox" browser
    When user opens url "https://www.wexinc.com"
    And I validate homepage is open
    Then my focus is on the search functionality
    Then I validate all search categories
    
    When I searched for a value "Travel" in All Wex category
    Then I validate that valid data are returned
    
    When I searched for a value "Wex" in Corporate Payment category
    Then I validate that valid data are returned
    
    When I searched for a value "Travel" in Fleet category
    Then I validate that valid data are returned
    
    When I searched for a value "Travel" in Wex Corporate category
    Then I validate that valid data are returned
    
    When I searched for a value "Travel" in Wex Health category
    Then I validate that valid data are returned
    
    Scenario: Validate that Search functionality for Wex website is working as expected using invalid(data expected NOT to return data results) data.
    Given I lunch "firefox" browser
    When user opens url "https://www.wexinc.com"
    And I validate homepage is open
    Then my focus is on the search functionality
    Then I validate all search categories
    
    When I searched for a value "oewryoieyrieioieo" in All Wex category
    Then I validate that no results that meet returned
    
    When I searched for a value "oewryoieyrieioieo" in Corporate Payment category
    Then I validate that no results that meet returned
    
    When I searched for a value "oewryoieyrieioieo" in Fleet category
    Then I validate that no results that meet returned
    
    When I searched for a value "oewryoieyrieioieo" in Wex Corporate category
    Then I validate that no results that meet returned
    
    When I searched for a value "oewryoieyrieioieo" in Wex Health category
    Then I validate that no results that meet returned
    

