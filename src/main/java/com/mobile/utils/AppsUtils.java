package com.mobile.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.WebDriverFacade;

import static com.mobile.utils.Constants.*;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static io.appium.java_client.remote.MobilePlatform.IOS;
import static net.serenitybdd.core.Serenity.getDriver;

public class AppsUtils {

    public static AppiumDriver getMobileDriver() {
        return (AppiumDriver) ((WebDriverFacade) getDriver()).getProxiedDriver();
    }

    public static AndroidDriver getAndroidDriver() {
        return (AndroidDriver) ((WebDriverFacade) getDriver()).getProxiedDriver();
    }

    public static IOSDriver getIOSDriver() {
        return (IOSDriver) ((WebDriverFacade) getDriver()).getProxiedDriver();
    }

    public static void navigateBack() {
        if (isAndroid()) getAndroidDriver().navigate().back();
        if (isIOS()) getIOSDriver().navigate().back();
    }

    public static boolean isAndroid() {
        return PLATFORM.equalsIgnoreCase(ANDROID);
    }

    public static boolean isIOS() {
        return PLATFORM.equalsIgnoreCase(IOS);
    }

    public static void changeApp(String packageName) {
        if (isAndroid()) getAndroidDriver().activateApp(packageName);
        if (isIOS()) getIOSDriver().activateApp(packageName);
    }

    public static boolean isKeyboardShown() {
        if (isAndroid()) return getAndroidDriver().isKeyboardShown();
        return getIOSDriver().isKeyboardShown();
    }
}
