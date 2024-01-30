package com.bdd.stepdefinitions;

import com.mobile.tasks.AddProduct;
import io.cucumber.java.en.Given;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CartStepDefinition {

    @Given("I entry to product {string}")
    public void iEntryToProduct(String product) {
        theActorInTheSpotlight().attemptsTo(AddProduct.toCart());
    }
}
