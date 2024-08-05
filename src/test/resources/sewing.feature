Feature: Someone came in with custom request for Doom Guy and would like a custom costume for a comic-con event
    Scenario: The customer wants a costume for Doom Guy from our catalog, number 12A, but we don't have the measurements
      Given the customer wants a costume for Doom 1993
      When the customer selects costume 12A from our catalog
      Then present a screen that will ask for inseam, neck, waist, sleeve and a diagram of what all that means
    Scenario: The customer wants a costume for Doom Guy but doesn't like the catalog selection and we don't have the measurements
       Given the customer wants a costume for Doom Guy 1993
       When the customer requests a custom made costume
       And the costume complexity factor is 8
       Then present a screen that will state the deposit amount of $300
       And present a screen that will ask for inseam, neck, waist, sleeve and a diagram of what all that means
