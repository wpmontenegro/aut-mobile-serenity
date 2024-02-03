package com.mobile.utils;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.apache.commons.lang3.StringUtils;

import java.util.Properties;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class PropertiesUtil {
    private static final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

    public static Properties getPropertiesWithPrefix(String prefix) {
        return environmentVariables.getPropertiesWithPrefix(prefix);
    }

    public static String getProperty(String propertyName) {
        String propertyValue = environmentVariables.getProperty(propertyName);
        if (StringUtils.isBlank(propertyValue)) {
            propertyValue = environmentVariables.getValue(propertyName);
        }
        return propertyValue;
    }

    public static String getOptionalProperty(String propertyName) {
        return EnvironmentSpecificConfiguration.from(environmentVariables)
                .getOptionalProperty(propertyName).orElse(EMPTY);
    }
}