package com.mobile.utils;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateData {
    private static final String REGEX_MASK_BEHIND = "(?<=.{%s}).";
    private static final String REGEX_MASK_AHEAD = ".(?=.{%s})";
    private static final String MASK_CHARACTER = "*";

    public static int randomInteger(int minInclusive, int maxExclusive) {
        return ThreadLocalRandom.current().nextInt(minInclusive, maxExclusive);
    }

    public static String maskLookAhead(String rawData, int length) {
        return rawData.replaceAll(String.format(REGEX_MASK_AHEAD, length), MASK_CHARACTER);
    }

    public static String maskLookBehind(String rawData, int length) {
        return rawData.replaceAll(String.format(REGEX_MASK_BEHIND, length), MASK_CHARACTER);
    }
}