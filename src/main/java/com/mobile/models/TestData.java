package com.mobile.models;

import java.util.HashMap;
import java.util.Map;

public class TestData {
    private static TestData instance = null;
    private static Map<String, String> testData = null;

    private TestData() {
    }

    public static TestData getInstance() {
        if (instance == null) {
            instance = new TestData();
            testData = new HashMap<>();
        }
        return instance;
    }

    public Map<String, String> getTestData() {
        return testData;
    }
}
