package qa.ecomm.spacln.ui.page.component;

import org.openqa.selenium.WebDriver;

public abstract class BaseComponent {
    protected WebDriver driver;

    public BaseComponent(WebDriver driver) {
        this.driver = driver;
    }
}
