Feature: Customer wants to rent a combine
    Scenario: Customer requests a combine for two weeks starting on 1/10/2010 and one is available close by
        Given a customer
        And a request for a combine for 2 weeks
        And a start date of 1/10/2010
        And the product is under 5 miles away
        When a customer submits the request
        Then a notification is sent to customer with possible rental choices
    Scenario: Customer makes a choice from the notification but it has already been rented
        Given a customer
        And a selection of choices provided
        When the customer makes a selection
        And the selection is no longer available
        Then a notification is sent that their selection is no longer available
        And they're given other possible rental choices
    Scenario: Customer requests a combine for two weeks starting on 1/10/2010 and one is available close by
        Given a customer
        And a request for a combine for 2 weeks
        And a start date of 1/10/2010
        And the product is under 20 miles away
        When a customer submits the request
        Then a notification is sent to customer with possible rental choices
        And a highlight that it is more than 10 miles away
    Scenario: Customer declines all the choices
        Given a customer
        And a list of possible rental choices
        When the customer declines the choices
        Then send a notification offering a alert when the rental will be available
