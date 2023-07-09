package qa.ecomm.spacln.ui.page;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import qa.ecomm.spacln.config.ConfigurationManager;
import qa.ecomm.spacln.ui.page.component.HeaderComponent;

/*
 * This class defines the basic functionalities of a POM class.
 */

public class BasePage {
    protected WebDriver driver;

    public HeaderComponent headerComponent;

    public void initialize(final WebDriver webdriver) {
        this.driver = webdriver;
        //IP driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
       //IP  PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
        headerComponent = new HeaderComponent(driver);
    }

    public void captureScreenshot(String fileName) {
        Shutterbug.shootPage(driver).withName(fileName).save(ConfigurationManager.config().baseScreenshotPath());
    }
}
