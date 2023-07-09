package qa.ecomm.spacln.ui.page.login;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.ecomm.spacln.config.ConfigurationManager;
import qa.ecomm.spacln.ui.page.BasePage;
import qa.ecomm.spacln.ui.page.BasePageFactory;
import qa.ecomm.spacln.ui.page.home.HomePage;

/*
This class captures the relevant UI components and functionalities of the login page.
 */
public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement txtUsername;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(id="rememberme")
    private WebElement chkRememberme;

    //@FindBy(id = "login-button")
   // @FindBy(id="login")
    /*@FindBys({
            @FindBy(className="btn btn-dark btn-block my-4 d-flex"),
            @FindBy(linkText="Login")
    })*/
    @FindBy(name="login")
    private WebElement btnLogin;

    public LoginPage open() {
        driver.get(ConfigurationManager.config().myAccountUrl());
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

    public LoginPage selectRememberMe(final boolean isRemembertrue) {
        if(isRemembertrue)
        chkRememberme.click();

        return this;
    }

    public String getErrorMessage() {
       /* return driver.findElement(By.className("error-message-container"))
                .findElement(By.tagName("h3"))
                /html/body/div[2]/div[1]/div[2]/div/div[1]/ul/li
                /html/body/div[2]/div[1]/div[2]/div/div[1]/ul/li
                .getText();*/
        return driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div[1]/ul/li")).getText();

    }

    public  String getPageHeader(){
        return driver.findElement(By.tagName("h1")).getText();
    }
    public HomePage clickOnLogin() {
        btnLogin.click();
        return BasePageFactory.createInstance(driver, HomePage.class);
    }

}
