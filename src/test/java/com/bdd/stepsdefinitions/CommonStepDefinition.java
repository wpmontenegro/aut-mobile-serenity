package com.bdd.stepsdefinitions;

import com.mobile.tasks.Load;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CommonStepDefinition {

    @Given("I load test data with a table")
    public void iLoadTestDataWithATable(List<Map<String, String>> testDataList) {
        theActorInTheSpotlight().attemptsTo(Load.testData(testDataList));
    }
}
