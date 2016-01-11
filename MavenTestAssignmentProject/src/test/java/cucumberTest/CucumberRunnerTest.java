package cucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        plugin = { "pretty", "html:target/cucumber" },
        glue = "cucumberTest",
        features = "classpath:cucumberTest/FirstTestCase.feature"
)
public class CucumberRunnerTest {
}
