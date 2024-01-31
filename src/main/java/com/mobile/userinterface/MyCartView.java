package com.mobile.userinterface;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MyCartView {

    public static final Target LBL_PRODUCT_NAME = Target.the("Label Product Name")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@content-desc=\"product label\"]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name='product label']"));

    public static final Target ITEM_REMOVE = Target.the("Item Remove")
            .locatedForAndroid(By.xpath("//android.view.ViewGroup[@content-desc=\"remove item\"]"))
            .locatedForIOS(AppiumBy.iOSNsPredicateString("label == \"Remove Item\""));
}
