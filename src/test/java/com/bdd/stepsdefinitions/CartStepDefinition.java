package com.bdd.stepsdefinitions;

import com.mobile.models.TestData;
import com.mobile.questions.VerifyProduct;
import com.mobile.tasks.AddProduct;
import com.mobile.tasks.ChooseProduct;
import com.mobile.tasks.OpenDeeplink;
import com.mobile.tasks.RemoveProduct;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CartStepDefinition {

    @Given("I entry to product {string}")
    public void iEntryToProduct(String productName) {
        theActorInTheSpotlight().attemptsTo(ChooseProduct.with(productName));
    }

    @When("I add it to the cart")
    public void iAddItToTheCart() {
        theActorInTheSpotlight().attemptsTo(AddProduct.toCart());
    }

    @Then("the product should be shown in the cart")
    public void theProductShouldBeShownInTheCart() {
        theActorInTheSpotlight().should(seeThat(VerifyProduct.withName(),
                is(equalTo(TestData.getInstance().getData("productName")))));
        theActorInTheSpotlight().attemptsTo(RemoveProduct.fromCart());
    }

    @When("add a product to cart by deeplink")
    public void addAProductToCartByDeeplink() {
        theActorInTheSpotlight().attemptsTo(OpenDeeplink.toAddItems());
    }
}
