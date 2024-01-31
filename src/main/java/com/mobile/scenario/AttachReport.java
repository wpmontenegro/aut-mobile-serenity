package com.mobile.scenario;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.OutputType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mobile.scenario.ManageScenario.getScenario;
import static com.mobile.utils.AppsUtils.getMobileDriver;

public class AttachReport {
    private static final Logger LOGGER = LoggerFactory.getLogger(AttachReport.class);

    public static void takeScreenShoot() {
        if (getScenario() == null)
            throw new IllegalArgumentException("There is no scenario configured");
        if (getMobileDriver() == null)
            throw new IllegalArgumentException("There is no driver active");

        byte[] screenshot = getMobileDriver().getScreenshotAs(OutputType.BYTES);
        LOGGER.info("Attaching evidence into Cucumber Report");
        getScenario().attach(screenshot, "image/jpeg", "evidence");
    }

    public static void shotWhenFail() {
        if (getScenario().isFailed())
            takeScreenShoot();
    }
}
