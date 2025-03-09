package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = {"stepdefinations"},
        features = "src/test/java/featureFiles"
)
public class MyTestNGRunnerTest  extends AbstractTestNGCucumberTests {
}
