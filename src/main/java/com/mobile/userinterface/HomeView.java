package com.mobile.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeView {

    public static final Target LBL_PRODUCTS = Target.the("Title Products")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text=\"Products\"]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name=\"Products\"]"));
}
