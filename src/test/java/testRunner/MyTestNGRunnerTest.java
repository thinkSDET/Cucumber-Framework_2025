package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = {"stepdefinations"},
        features = "src/test/featureFiles",
        dryRun = false
     //   tags = "@Smoke"
)
public class MyTestNGRunnerTest  extends AbstractTestNGCucumberTests {
}
