package com.mobile.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.mobile.userinterface.HomeView.LBL_PRODUCTS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProduct implements Task {
    public static AddProduct toCart() {
        return instrumented(AddProduct.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LBL_PRODUCTS));
    }
}