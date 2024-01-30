package com.mobile.utils;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateData {
    public static int randomInteger(int minInclusive, int maxExclusive) {
        return ThreadLocalRandom.current().nextInt(minInclusive, maxExclusive);
    }
}