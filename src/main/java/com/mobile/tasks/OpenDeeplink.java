package com.mobile.tasks;

import com.mobile.models.TestData;
import com.mobile.utils.AppsUtils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenDeeplink implements Task {

    private static final String ADD_ITEMS_PATH = "cart/id=%s&amount=%s&color=%s";

    public static OpenDeeplink toAddItems() {
        return instrumented(OpenDeeplink.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String path = String.format(ADD_ITEMS_PATH, TestData.getInstance().getData("id"),
                TestData.getInstance().getData("amount"), TestData.getInstance().getData("color"));
        actor.attemptsTo(AppsUtils.openDeepLink(path));
    }
}
