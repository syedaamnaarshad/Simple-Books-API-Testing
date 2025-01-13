import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

    @CucumberOptions(
            features = "src/test/resources/API_Test.feature",    // Path to your feature files
            glue = "stepDefinition",                    // Package containing step definitions
            plugin = {
                    "pretty",
                    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" // Allure plugin for Cucumber
            }
    )
    public class TestRunner extends AbstractTestNGCucumberTests {

    }