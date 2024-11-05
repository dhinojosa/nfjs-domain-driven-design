package com.xyzcorp.cucumber;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;


public class ConstructionRentalSteps {

    @Given("a customer")
    public void anExistingCustomer() {

    }

    @And("a request for a {string} for {int} {string}")
    public void aRequestForACombineForWeeks(String rental, int length, String time) {
        //Create a duration

    }
}
