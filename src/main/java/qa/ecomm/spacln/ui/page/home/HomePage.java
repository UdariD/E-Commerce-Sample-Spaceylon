package qa.ecomm.spacln.ui.page.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.ecomm.spacln.config.ConfigurationManager;
import qa.ecomm.spacln.ui.page.BasePage;
import qa.ecomm.spacln.ui.page.BasePageFactory;
import qa.ecomm.spacln.ui.page.component.HeaderComponent;
import qa.ecomm.spacln.ui.page.login.LoginPage;

public final class HomePage extends BasePage {


    @FindBy(id = "64a9a81fc53c2")
    private WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"menu-item-501513\"]/a")
    private WebElement lblTitle;

    public HomePage open() {
        driver.get(ConfigurationManager.config().baseUrl());
        return this;
    }

    public String getTitle() {
        return lblTitle.getText();
    }

    public LoginPage clickOnLoginIcon(){
        return headerComponent.clickOnLoginRegIcon();
    }
}
