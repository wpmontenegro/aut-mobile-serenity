package com.mobile.utils;

import java.util.Objects;

public class Constants {
    public static String PLATFORM = Objects.toString(System.getProperty("platform"), "android");
}
