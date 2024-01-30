package com.mobile.scenario;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static com.mobile.scenario.ManageScenario.getScenario;

public class AttachReport {

    public static Performable takeScreenShoot() {
        return Task.where(actor -> {
            if (getScenario() == null)
                throw new IllegalArgumentException("There is no scenario configured");

            byte[] screenshot = new byte[]{};
            //byte[] screenshot = MobileDriverManager.getDriver().getScreenshotAs(OutputType.BYTES);
            getScenario().attach(screenshot, "image/jpeg", "evidence");
        });
    }

    public static Performable shotWhenFail() {
        return Task.where(actor -> {
            if (getScenario().isFailed())
                takeScreenShoot();
        });
    }
}
