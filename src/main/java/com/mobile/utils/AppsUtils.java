package com.mobile.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.webdriver.WebDriverFacade;

import static com.mobile.utils.Constants.PLATFORM;
import static net.serenitybdd.core.Serenity.getDriver;

public class AppsUtils {

    public static AppiumDriver getMobileDriver() {
        return (AppiumDriver) ((WebDriverFacade) getDriver()).getProxiedDriver();
    }

    public static AndroidDriver getAndroidDriver() {
        return (AndroidDriver) ((WebDriverFacade) getDriver()).getProxiedDriver();
    }

    public static boolean isAndroid() {
        return PLATFORM.equalsIgnoreCase("Android");
    }

    public static boolean isIOS() {
        return PLATFORM.equalsIgnoreCase("iOS");
    }
}
