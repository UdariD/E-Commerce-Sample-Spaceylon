package qa.ecomm.spacln.ui.page.home;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import qa.ecomm.spacln.config.ConfigurationManager;
import qa.ecomm.spacln.ui.page.BasePage;
import qa.ecomm.spacln.ui.page.BasePageFactory;
import qa.ecomm.spacln.ui.page.component.HeaderComponent;
import qa.ecomm.spacln.ui.page.login.LoginPage;

import java.util.NoSuchElementException;
import java.util.Set;

public final class HomePage extends BasePage {


    @FindBy(xpath = "//*[@id=\"menu-item-501513\"]/a")
    private WebElement lblTitle;

    @FindBy(xpath = "//*[@id=\"search\"]/form/button")
    private WebElement searchButton;
    @FindBy(id="64ace1a257a91")
    private WebElement searchBar;


    public HomePage open() {
        driver.get(ConfigurationManager.config().baseUrl());
        try {
            driver.switchTo ().alert ().dismiss ();
        } catch (NoAlertPresentException e) {

        } finally {
            return this;
        }


       /*  // Get the list of all windows.
        Set<String> windowHandles = driver.getWindowHandles();

        // Iterate through the list of windows and close any loading windows.
        for (String windowHandle : windowHandles) {
               driver.switchTo().window(windowHandle);
               System.out.println("Page title of popup: "+ driver.getTitle());
               driver.close();
        }
        */

    }

    public String getTitle() {
        return lblTitle.getText();
    }

    public LoginPage clickOnLoginIcon(){
        return headerComponent.clickOnLoginRegIcon();
    }

    public SearchResultPage typeSearchWord(final String input) {

        //Creating object of an Actions class
        Actions action = new Actions (driver);

        //Performing the mouse hover action on the target element.
        action.moveToElement(searchButton).perform();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException (e);
        }

        WebElement ele = driver.findElement(By.xpath ("//*[@id=\"64ace1a257a91\"]"));
        ele.sendKeys (input);
        ele.sendKeys(Keys.ENTER);
        /*searchBar.clear();
        searchBar.sendKeys(input);
        searchBar.sendKeys(Keys.ENTER);*/
        return BasePageFactory.createInstance(driver, SearchResultPage.class);
    }

    public SearchResultPage clickOnSubMenuBabyCare(){
        return headerComponent.clickOnSubMenuBabyCare ();
    }

}
