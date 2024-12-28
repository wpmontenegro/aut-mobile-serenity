package com.mobile.integrations.browserstack;

import com.mobile.exceptions.AutomationException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.DriverSource;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import static com.mobile.scenario.ManageScenario.getScenario;
import static com.mobile.utils.AppsUtils.isAndroid;
import static com.mobile.utils.Constants.CAPABILITIES_PREFIX;
import static com.mobile.utils.PropertiesUtil.*;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class BrowserStackDriver implements DriverSource {

    private static final Logger LOGGER = LoggerFactory.getLogger(BrowserStackDriver.class);

    @Override
    public AppiumDriver newDriver() {
        AppiumDriver appiumDriver;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        Properties properties = getPropertiesWithPrefix(CAPABILITIES_PREFIX);
        for (String propertyName : properties.stringPropertyNames()) {
            String propertyValue = properties.getProperty(propertyName);
            desiredCapabilities.setCapability(propertyName.replace(CAPABILITIES_PREFIX, EMPTY), propertyValue);
        }

        if (ObjectUtils.anyNull(desiredCapabilities.getCapability("deviceName"),
                desiredCapabilities.getCapability("osVersion"))) {
            BrowserStackDevices device = BrowserStackDevices.getRandomDevice();
            desiredCapabilities.setCapability("deviceName", device.getDeviceName());
            desiredCapabilities.setCapability("osVersion", device.getOsVersion());
        }

        desiredCapabilities.setCapability("sessionName", getScenario().getName());

        try {
            if (isAndroid()) {
                appiumDriver = new AndroidDriver(new URL(BrowserStackCredentials.getUrl()), desiredCapabilities);
                LOGGER.info("Running automation on Android");
            } else {
                appiumDriver = new IOSDriver(new URL(BrowserStackCredentials.getUrl()), desiredCapabilities);
                LOGGER.info("Running automation on iOS");
            }
        } catch (MalformedURLException | RuntimeException e) {
            throw new AutomationException("An error occurred while raising the driver with the Appium server URL", e);
        }
        LOGGER.info("Driver raised with {}", desiredCapabilities);

        return appiumDriver;
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}