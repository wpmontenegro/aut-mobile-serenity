package com.mobile.userinterface;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.mobile.utils.Constants.TIME_OUT_15;

public class MenuView {

    public static final Target ICON_CART_MENU = Target.the("Title Products")
            .locatedForAndroid(By.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]"))
            .locatedForIOS(AppiumBy.iOSNsPredicateString("label == \"1\" AND name == \"tab bar option cart\""))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_15));
}
