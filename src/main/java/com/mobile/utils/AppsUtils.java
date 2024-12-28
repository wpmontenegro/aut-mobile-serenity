package com.mobile.utils;

import com.mobile.exceptions.AutomationException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.webdriver.WebDriverFacade;

import java.util.HashMap;

import static com.mobile.utils.Constants.*;
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
        return PLATFORM.equalsIgnoreCase("Android");
    }

    public static boolean isIOS() {
        return PLATFORM.equalsIgnoreCase("iOS");
    }

    public static void changeApp(String packageName) {
        if (isAndroid()) getAndroidDriver().activateApp(packageName);
        if (isIOS()) getIOSDriver().activateApp(packageName);
    }

    public static Performable openDeepLink(String path) {
        return Task.where(actor -> {
            if (isAndroid()) {
                HashMap<String, String> map = new HashMap<>();
                map.put("url", APP_NAME + "://" + path);
                map.put("package", PACKAGE_NAME);
                getAndroidDriver().executeScript("mobile: deepLink", map);
            }
            if (isIOS()) {
                throw new AutomationException("Method not implemented");
            }
        });
    }
}
