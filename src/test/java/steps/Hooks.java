package steps;

import base.BaseUtil;
import io.cucumber.java.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class Hooks extends BaseUtil {

    private BaseUtil base;

    public Hooks(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() {
        System.out.println("Opening Chrome browser");
        System.setProperty("webdriver.chrome.driver","/Users/arifsyed/Documents/Work/Selenium/chromedriver");
        base.Driver = new ChromeDriver();
    }

    @After
    public void TearDownTest() {
        System.out.println("Tearing down mock browser");
    }

    @BeforeStep
    public void BeforeStepExecution(Scenario scenario) {
        System.out.println("The execution scenario step Before " + scenario.getLine());
    }

    @AfterStep
    public void AfterStepExecution(Scenario scenario) {
        System.out.println("The execution scenario step After " + scenario.getLine());
    }

}
