package com.xyzcorp.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SewingSteps {

    @Given("the customer wants a costume for {costumeName} {int}")
    public void theCustomerWantsACostumeForDoomGuy(String costumeName, int year) {

    }

    @Given("the customer wants a costume for Doom Guy {int}")
    public void theCustomerWantsACostumeForDoom(int arg0) {
    }
}
