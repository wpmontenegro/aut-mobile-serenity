package com.mobile.interactions;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.mobile.utils.AppsUtils.*;

public class Keyboard implements Interaction {

    private final String value;
    private static final String XPATH_KEYBOARD_IOS = "//XCUIElementTypeKey[@name='%s']";

    public Keyboard(String value) {
        this.value = value;
    }

    public Keyboard enterValue(String value) {
        return Tasks.instrumented(Keyboard.class, value);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        char[] characters = value.toCharArray();
        for (char c : characters) {
            if (isAndroid())
                getAndroidDriver().pressKey(new KeyEvent(AndroidKey.valueOf(String.format("DIGIT_%s", c))));
            if (isIOS())
                actor.attemptsTo(Click.on(String.format(XPATH_KEYBOARD_IOS, c)));
        }
    }
}
