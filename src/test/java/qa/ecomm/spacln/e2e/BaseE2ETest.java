package qa.ecomm.spacln.e2e;


/*
This class provides the basic functionalities required by the test scripts. End-to-End
 */

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import qa.ecomm.spacln.config.ConfigurationManager;
import qa.ecomm.spacln.ui.page.BasePage;
import qa.ecomm.spacln.ui.page.BasePageFactory;
import qa.ecomm.spacln.util.DriverManager;
import qa.ecomm.spacln.util.TestListener;

@Listeners(TestListener.class)
public abstract class BaseE2ETest {

    private final WebDriver driver = DriverManager.createDriver();

    public abstract void initialize();

    protected String getTestDataFilePath(String path) {
        return ConfigurationManager.config().baseTestDataPath() + path;
    }

    protected String getScreenshotFilePath(String path) {
        return ConfigurationManager.config().baseScreenshotPath() + path;
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
