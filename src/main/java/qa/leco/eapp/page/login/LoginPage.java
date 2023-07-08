package qa.leco.eapp.page.login;


import static qa.leco.eapp.config.ConfigurationManager.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import qa.leco.eapp.page.BasePage;

/*
This class captures the relevant UI components and functionalities of the login page.
 */
public class LoginPage extends BasePage {

    @FindBy(id = "un")
    private WebElement txtUsername;

    @FindBy(id = "pw")
    private WebElement txtPassword;

    //@FindBy(id = "login-button")
   // @FindBy(id="login")
    /*@FindBys({
            @FindBy(className="btn btn-dark btn-block my-4 d-flex"),
            @FindBy(linkText="Login")
    })*/
    @FindBy(xpath="//*[@id=\"mimin\"]/div/form/div/div[1]/input[1]")
    private WebElement btnLogin;

    public LoginPage open() {
        driver.get(config().baseUrl());

        return this;
    }

    public LoginPage typeUsername(final String username) {
        txtUsername.clear();
        txtUsername.sendKeys(username);

        return this;
    }

    public LoginPage typePassword(final String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);

        return this;
    }

    public String getErrorMessage() {
       /* return driver.findElement(By.className("error-message-container"))
                .findElement(By.tagName("h3"))
                .getText();*/
        return driver.findElement(By.xpath("//*[@id=\"mimin\"]/div/form/div/div[1]/div[3]/label")).getText();

    }

    public void clickOnLogin() {
        btnLogin.click();
    }

}
