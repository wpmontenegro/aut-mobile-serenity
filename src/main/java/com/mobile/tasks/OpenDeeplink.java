package com.mobile.tasks;

import com.mobile.interactions.Gestures;
import com.mobile.utils.AppsUtils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.mobile.userinterface.BrowserView.BAR_ADDRESS;
import static com.mobile.userinterface.BrowserView.INPUT_URL;
import static com.mobile.utils.AppsUtils.*;
import static com.mobile.utils.Constants.CHAR_ENTER_KEY;
import static com.mobile.utils.Constants.TIME_OUT_10;
import static com.mobile.utils.DeeplinkPaths.APP_NAME;
import static com.mobile.utils.DeeplinkPaths.BROWSER_PACKAGE_IOS;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OpenDeeplink implements Task {

    private static final String URL_FORMAT = "%s://%s";
    private final String path;

    public OpenDeeplink(String path) {
        this.path = path;
    }

    public static OpenDeeplink withPath(String path) {
        return instrumented(OpenDeeplink.class, path);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String url = String.format(URL_FORMAT, APP_NAME, path);
        if (isAndroid()) {
            actor.attemptsTo(Gestures.useDeeplink(url));
        }
        if (isIOS()) {
            changeApp(BROWSER_PACKAGE_IOS);
            actor.attemptsTo(Check.whether(AppsUtils.isKeyboardShown()).otherwise(
                    WaitUntil.the(BAR_ADDRESS, isVisible()).forNoMoreThan(TIME_OUT_10).seconds(),
                    Click.on(BAR_ADDRESS)
            ));
            actor.attemptsTo(Enter.theValue(url + CHAR_ENTER_KEY).into(INPUT_URL));
        }
    }
}
