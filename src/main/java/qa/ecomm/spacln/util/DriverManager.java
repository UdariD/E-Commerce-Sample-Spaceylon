package qa.ecomm.spacln.util;

import org.openqa.selenium.WebDriver;
import qa.ecomm.spacln.config.ConfigurationManager;

/*
This class provides a singleton instance of WebDriver.
 */

public class DriverManager {

    private static WebDriver driver = null;

    private DriverManager() {}

    /**
     * @return an instance of browser driver implementation
     */
    public static WebDriver createDriver() {
        if (driver == null) {
            driver =
                    BrowserFactory.valueOf(ConfigurationManager.config().browser().toUpperCase())
                            .initializeDriver();
        }

        return driver;
    }
}
