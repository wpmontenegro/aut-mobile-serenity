package com.mobile.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.mobile.userinterface.MenuView.ICON_CART_MENU;
import static com.mobile.userinterface.ProductView.BTN_ADD_TO_CART;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProduct implements Task {

    public static AddProduct toCart() {
        return instrumented(AddProduct.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BTN_ADD_TO_CART));
        actor.attemptsTo(Click.on(ICON_CART_MENU));
    }
}
