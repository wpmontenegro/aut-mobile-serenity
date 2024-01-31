package com.mobile.userinterface;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class ProductView {

    public static final Target BTN_ADD_TO_CART = Target.the("Button Add To Cart")
            .locatedForAndroid(AppiumBy.accessibilityId("Add To Cart button"))
            .locatedForIOS(AppiumBy.iOSNsPredicateString("label == \"Add To Cart\""));
}
