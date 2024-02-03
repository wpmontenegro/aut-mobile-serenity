package com.mobile.integrations;

import com.mobile.exceptions.AutomationException;
import com.mobile.utils.BrowserStackDevices;
import io.appium.java_client.AppiumDriver;
import net.thucydides.core.webdriver.DriverSource;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.Properties;

import static com.mobile.utils.Constants.CAPABILITIES_PREFIX;
import static com.mobile.utils.PropertiesUtil.*;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class BrowserStackDriver implements DriverSource {

    private static final Logger LOGGER = LoggerFactory.getLogger(BrowserStackDriver.class);
    private static final String BROWSERSTACK_HUB = "hub.browserstack.com/wd/hub";

    @Override
    public AppiumDriver newDriver() {
        AppiumDriver appiumDriver;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        Properties properties = getPropertiesWithPrefix(CAPABILITIES_PREFIX);
        for (String propertyName : properties.stringPropertyNames()) {
            String propertyValue = properties.getProperty(propertyName);
            desiredCapabilities.setCapability(propertyName.replace(CAPABILITIES_PREFIX + ".", EMPTY), propertyValue);
        }

        if (ObjectUtils.anyNull(desiredCapabilities.getCapability("deviceName"),
                desiredCapabilities.getCapability("osVersion"))) {
            BrowserStackDevices device = BrowserStackDevices.getRandomDevice();
            desiredCapabilities.setCapability("deviceName", device.getDeviceName());
            desiredCapabilities.setCapability("osVersion", device.getOsVersion());
        }

        try {
            appiumDriver = new AppiumDriver(new URL(getUrl()), desiredCapabilities);
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

    public static String getUrl() {
        String user = getUser();
        String keyAccess = getAccessKey();
        if (user.isEmpty() || keyAccess.isEmpty()) {
            throw new AutomationException("You have tried to connect to browserstack but you must define the credentials correctly.");
        }
        return String.format("https://%s:%s@%s", user, keyAccess, BROWSERSTACK_HUB);
    }

    public static String getUser() {
        String userConf = getOptionalProperty(CAPABILITIES_PREFIX + ".browserstack.user");
        return Optional.ofNullable(getProperty("BROWSERSTACK_USER")).orElse(userConf);

    }

    public static String getAccessKey() {
        String keyConf = getOptionalProperty(CAPABILITIES_PREFIX + ".browserstack.key");
        return Optional.ofNullable(getProperty("BROWSERSTACK_KEY")).orElse(keyConf);

    }
}