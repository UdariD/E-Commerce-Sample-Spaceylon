package qa.leco.eapp.util;

import static qa.leco.eapp.config.ConfigurationManager.config;
import org.openqa.selenium.WebDriver;

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
                    BrowserFactory.valueOf(config().browser().toUpperCase())
                            .initializeDriver();
        }

        return driver;
    }
}
