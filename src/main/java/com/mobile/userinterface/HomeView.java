package com.mobile.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeView {

    public static final Target LBL_PRODUCTS = Target.the("Title Products")
            .locatedForAndroid(By.xpath("//android.widget.TextView[@text=\"Products\"]"))
            .locatedForIOS(By.xpath("//XCUIElementTypeStaticText[@name=\"Products\"]"));

    public static final Target VIEW_SCROLL = Target.the("View Scroll")
            .locatedForAndroid(By.className("android.widget.ScrollView"))
            .locatedForIOS(By.xpath("(//XCUIElementTypeScrollView)[2]"));

    public static final Target TXT_PRODUCT_NAME_ANDROID = Target.the("Text Product Name")
            .locatedBy("//android.widget.TextView[@content-desc=\"store item text\" and @text=\"{0}\"]");

    public static final Target TXT_PRODUCT_NAME_IOS = Target.the("Text Product Name")
            .locatedBy("//XCUIElementTypeStaticText[@name='store item text' and @value=\"{0}\"]");
}
