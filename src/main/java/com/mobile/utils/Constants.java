package com.mobile.utils;

public class Constants {
    public static final String PLATFORM = System.getProperty("platform");
    public static final long TIME_OUT_10 = 10;
    public static final long TIME_OUT_15 = 15;
    public static final long TIME_OUT_30 = 30;
    public static final double DISTANCE_SCROLL_QUARTER = 0.25;
    public static final double DISTANCE_SCROLL_HALF = 0.5;
    public static final double DISTANCE_SCROLL_MAX = 1;
    public static final String CAPABILITIES_PREFIX = String.format("%s.%s.%s", "environments", PropertiesUtil.getProperty("environment"), "appium");
}