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


    //**************************************  Register section **********************

    @FindBy(id="reg_billing_first_name")
    private WebElement firstName;

    @FindBy(id="reg_billing_last_name")
    private WebElement lastName;

    @FindBy(id="reg_billing_phone")
    private WebElement phone;

    @FindBy(id="reg_username")
    private WebElement userName;

    @FindBy(id="reg_email")
    private WebElement emailAddress;

    @FindBy(id="reg_password")
    private WebElement password;

    @FindBy(id="mailchimp_woocommerce_newsletter")
    private WebElement isSubscribe;

    @FindBy(name="register")
    private WebElement regButton;


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

    //**************************************  Register actions **********************

    public LoginPage typeFirstLastname(final String firstname , final String lastname) {
        firstName.clear();
        firstName.sendKeys(firstname);
        lastName.clear();
        lastName.sendKeys(lastname);
        return this;
    }

    public LoginPage typePhone(final String phoneNum) {
        phone.clear();
        phone.sendKeys(phoneNum);
        return this;
    }

    public LoginPage typeEmail(final String string) {
        emailAddress.clear();
        emailAddress.sendKeys(string);
        return this;
    }
    public LoginPage typeUserNameReg(final String string) {
        userName.clear();
        userName.sendKeys(string);
        return this;
    }
    public LoginPage typePasswordReg(final String string) {
        password.clear();
        password.sendKeys(string);
        return this;
    }

    public String getWelcomeMessage() {
        return driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div/p[1]")).getText();
    }
    public LoginPage clickOnRegister() {
        regButton.click();
        return BasePageFactory.createInstance(driver, LoginPage.class);
    }
}
