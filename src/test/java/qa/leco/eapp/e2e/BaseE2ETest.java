package qa.leco.eapp.e2e;


/*
This class provides the basic functionalities required by the test scripts. End-to-End
 */

import static qa.leco.eapp.config.ConfigurationManager.config;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import qa.leco.eapp.page.BasePage;
import qa.leco.eapp.page.BasePageFactory;
import qa.leco.eapp.util.DriverManager;
import qa.leco.eapp.util.TestListener;

@Listeners(TestListener.class)
public abstract class BaseE2ETest {

    private final WebDriver driver = DriverManager.createDriver();

    public abstract void initialize();

    protected String getTestDataFilePath(String path) {
        return config().baseTestDataPath() + path;
    }

    protected String getScreenshotFilePath(String path) {
        return config().baseScreenshotPath() + path;
    }

    protected <T extends BasePage> T createInstance(final Class<T> page) {
        return BasePageFactory.createInstance(driver, page);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass(alwaysRun = true)
    public void setup() {
        initialize();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
