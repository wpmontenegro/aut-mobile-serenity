package com.bdd.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"json:target/cucumber/cucumber.json"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features",
        glue = {"com.bdd.stepsdefinitions", "com.bdd.hooks"},
        stepNotifications = true
)

public class TestCartRunner {
}
