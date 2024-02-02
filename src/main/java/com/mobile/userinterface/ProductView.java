package com.mobile.userinterface;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

import java.time.Duration;

import static com.mobile.utils.Constants.TIME_OUT_15;

public class ProductView {

    public static final Target BTN_ADD_TO_CART = Target.the("Button Add To Cart")
            .locatedForAndroid(AppiumBy.accessibilityId("Add To Cart button"))
            .locatedForIOS(AppiumBy.iOSNsPredicateString("label == \"Add To Cart\""))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_15));
}
