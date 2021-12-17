package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

//@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features"}
        , plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"}
        , glue = "steps")
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider
//    @DataProvider (parallel = true) - for parallel execution
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
