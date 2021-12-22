package com.indra.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/feature/registerUs/registerUs.feature"
        , glue = "com.indra.stepsDefinitions"
        , snippets = SnippetType.CAMELCASE
)
public class RegisterUsRunners {
}
