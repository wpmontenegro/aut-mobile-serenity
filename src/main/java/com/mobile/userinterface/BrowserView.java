package com.mobile.userinterface;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class BrowserView {

    public static final Target BAR_ADDRESS = Target.the("Address Bar")
            .located(AppiumBy.iOSNsPredicateString("name CONTAINS 'URL' OR name CONTAINS 'TabBarItemTitle' OR value contains 'Search or enter website name'"));

    public static final Target INPUT_URL = Target.the("URL Field")
            .located(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeTextField' && name CONTAINS 'URL'"));
}
