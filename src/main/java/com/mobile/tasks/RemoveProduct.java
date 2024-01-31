package com.mobile.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.mobile.userinterface.MyCartView.ITEM_REMOVE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RemoveProduct implements Task {

    public static RemoveProduct fromCart() {
        return instrumented(RemoveProduct.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ITEM_REMOVE));
    }
}
