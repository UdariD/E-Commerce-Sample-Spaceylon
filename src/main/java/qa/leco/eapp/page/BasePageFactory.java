package qa.leco.eapp.page;


/*
 * This class provides an instance of subclass of BasePage.
 */

import org.openqa.selenium.WebDriver;

public class BasePageFactory {
    private BasePageFactory() {}

    public static <T extends BasePage> T createInstance(
            final WebDriver driver, final Class<T> page) {
        try {
            BasePage instance = page.getDeclaredConstructor().newInstance();
            instance.initialize(driver);
            return page.cast(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new NullPointerException("Page class instantiation failed. " + page.getName());
    }
}
