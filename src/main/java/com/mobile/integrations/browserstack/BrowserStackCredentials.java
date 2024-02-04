package com.mobile.integrations.browserstack;

import com.mobile.exceptions.AutomationException;

import java.util.Optional;

import static com.mobile.utils.Constants.CAPABILITIES_PREFIX;
import static com.mobile.utils.PropertiesUtil.getOptionalProperty;
import static com.mobile.utils.PropertiesUtil.getProperty;

public class BrowserStackCredentials {
    private static final String BROWSERSTACK_HUB = "hub.browserstack.com/wd/hub";

    public static String getUrl() {
        String user = getUser();
        String keyAccess = getAccessKey();
        if (user.isEmpty() || keyAccess.isEmpty()) {
            throw new AutomationException("You have tried to connect to browserstack but you must define the credentials correctly.");
        }
        return String.format("https://%s:%s@%s", user, keyAccess, BROWSERSTACK_HUB);
    }

    private static String getUser() {
        String userConf = getOptionalProperty(CAPABILITIES_PREFIX + ".browserstack.user");
        return Optional.ofNullable(getProperty("BROWSERSTACK_USER")).orElse(userConf);
    }

    private static String getAccessKey() {
        String keyConf = getOptionalProperty(CAPABILITIES_PREFIX + ".browserstack.key");
        return Optional.ofNullable(getProperty("BROWSERSTACK_KEY")).orElse(keyConf);
    }
}
