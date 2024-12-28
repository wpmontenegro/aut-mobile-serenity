package com.mobile.models;

import java.util.HashMap;
import java.util.Map;

public class TestData {
    private static TestData instance = null;
    private static Map<String, String> dataMap = null;

    private TestData() {
    }

    public static TestData getInstance() {
        if (instance == null) {
            instance = new TestData();
            dataMap = new HashMap<>();
        }
        return instance;
    }

    public String getData(String key) {
        return dataMap.get(key);
    }

    public void putData(String key, String value) {
        dataMap.put(key, value);
    }

    public Map<String, String> getDataMap() {
        return dataMap;
    }
}
