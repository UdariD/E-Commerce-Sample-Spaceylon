package qa.ecomm.spacln.ui.page.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.ecomm.spacln.ui.page.BasePageFactory;
import qa.ecomm.spacln.ui.page.home.HomePage;
import qa.ecomm.spacln.ui.page.login.LoginPage;

public final class HeaderComponent extends BaseComponent{

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickOnLoginRegIcon() {
        driver.findElement(By.xpath("//*[@id=\"header-main\"]/div[3]/div/a")).click();
        return BasePageFactory.createInstance(driver, LoginPage.class);
    }
}
