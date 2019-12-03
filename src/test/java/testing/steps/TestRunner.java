package testing.steps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json"},
        tags = {"not @ignore"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
