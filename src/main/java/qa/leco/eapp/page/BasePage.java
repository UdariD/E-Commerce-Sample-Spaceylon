package qa.leco.eapp.page;

import static qa.leco.eapp.config.ConfigurationManager.config;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.concurrent.TimeUnit;

/*
 * This class defines the basic functionalities of a POM class.
 */

public class BasePage {
    protected WebDriver driver;

    public void initialize(final WebDriver webdriver) {
        this.driver = webdriver;
        //IP driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
       //IP  PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    public void captureScreenshot(String fileName) {
        Shutterbug.shootPage(driver).withName(fileName).save(config().baseScreenshotPath());
    }
}
