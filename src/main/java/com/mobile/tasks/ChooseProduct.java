package com.mobile.tasks;

import com.mobile.interactions.Gestures;
import com.mobile.models.TestData;
import com.mobile.utils.Direction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.mobile.userinterface.HomeView.*;
import static com.mobile.utils.AppsUtils.isAndroid;
import static com.mobile.utils.AppsUtils.isIOS;
import static com.mobile.utils.Constants.DISTANCE_SCROLL_FOURTH_PART;
import static com.mobile.utils.Constants.TIME_OUT_10;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ChooseProduct implements Task {

    private final String productName;

    public ChooseProduct(String productName) {
        this.productName = productName;
    }

    public static ChooseProduct with(String productName) {
        return instrumented(ChooseProduct.class, productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        TestData.getInstance().putData("productName", productName);
        actor.attemptsTo(WaitUntil.the(LBL_PRODUCTS, isVisible())
                .forNoMoreThan(TIME_OUT_10).seconds());
        actor.attemptsTo(Gestures.scrollByDirectionIn(VIEW_SCROLL, Direction.DOWN, DISTANCE_SCROLL_FOURTH_PART));
        if (isAndroid()) actor.attemptsTo(Click.on(TXT_PRODUCT_NAME_ANDROID.of(productName)));
        if (isIOS()) actor.attemptsTo(Click.on(TXT_PRODUCT_NAME_IOS.of(productName)));
    }
}