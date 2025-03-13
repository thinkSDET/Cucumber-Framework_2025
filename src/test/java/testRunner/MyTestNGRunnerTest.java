package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        glue = {"stepDefinitions"},
        features = "src/test/featureFiles",
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        dryRun = false,
        monochrome = true
       // tags = "@regression1"
)
public class MyTestNGRunnerTest  extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = false)  // ✅ Force Scenario Outline to run sequentially
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
