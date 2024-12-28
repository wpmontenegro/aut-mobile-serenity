package com.mobile.tasks;

import com.mobile.interactions.Gestures;
import com.mobile.utils.Direction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;

import static com.mobile.userinterface.HomeView.VIEW_SCROLL;
import static com.mobile.userinterface.MenuView.ICON_CART_MENU;
import static com.mobile.userinterface.ProductView.BTN_ADD_TO_CART;
import static com.mobile.utils.Constants.DISTANCE_SCROLL_QUARTER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProduct implements Task {

    public static AddProduct toCart() {
        return instrumented(AddProduct.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Check.whether(Visibility.of(BTN_ADD_TO_CART))
                .otherwise(Gestures.scrollByDirectionIn(VIEW_SCROLL, Direction.DOWN, DISTANCE_SCROLL_QUARTER)));
        actor.attemptsTo(Click.on(BTN_ADD_TO_CART));
        actor.attemptsTo(Click.on(ICON_CART_MENU));
    }
}
