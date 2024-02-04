package com.bdd.hooks;

import com.mobile.scenario.AttachReport;
import com.mobile.scenario.ManageScenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Hook {

    @Before(order = 1)
    public void handleScenario(Scenario scenario) {
        ManageScenario.setScenario(scenario);
    }

    @Before(order = 2)
    public void init() {
        setTheStage(new OnlineCast());
        theActorCalled("User");
    }

    @After(order = 1)
    public void tearDown() {
        AttachReport.shotWhenFail();
    }

    @AfterStep
    public void takeEvidence() {
        AttachReport.takeScreenShoot();
    }
}
