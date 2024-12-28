package com.mobile.tasks;

import com.mobile.models.TestData;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Load {

    private static void loadData(List<Map<String, String>> data, Map<String, String> targetMap) {
        Set<Map.Entry<String, String>> dataSet = data.get(0).entrySet();
        targetMap.putAll(dataSet.stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }

    public static Performable testData(List<Map<String, String>> testDataList) {
        return Task.where(actor -> {
            if (!testDataList.isEmpty()) {
                loadData(testDataList, TestData.getInstance().getDataMap());
            }
        });
    }
}