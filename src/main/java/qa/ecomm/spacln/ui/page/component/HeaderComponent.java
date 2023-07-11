package qa.ecomm.spacln.ui.page.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import qa.ecomm.spacln.ui.page.BasePageFactory;
import qa.ecomm.spacln.ui.page.home.HomePage;
import qa.ecomm.spacln.ui.page.home.SearchResultPage;
import qa.ecomm.spacln.ui.page.login.LoginPage;

public final class HeaderComponent extends BaseComponent{


   // @FindBy(xpath = "//*[@id=\"menu-item-494981\"]/a")
   // private WebElement menuBabyCare;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickOnLoginRegIcon() {
        driver.findElement(By.xpath("//*[@id=\"header-main\"]/div[3]/div/a")).click();
        return BasePageFactory.createInstance(driver, LoginPage.class);
    }

    public SearchResultPage clickOnSubMenuBabyCare(){

        // Locating the Main Menu (Parent element) = menuBabyCare
        WebElement menuBabyCare = driver.findElement(By.xpath("//*[@id=\"menu-item-494981\"]/a"));

        //Instantiating Actions class
        Actions actions = new Actions(driver);

        //Hovering on main menu
        actions.moveToElement(menuBabyCare);

        // Locating the element from Sub Menu
        WebElement subMenu = driver.findElement(By.xpath("//*[@id=\"menu-item-494981\"]/div/div/div[1]/div[2]/a[1]/span/img"));

        //To mouseover on sub menu
        actions.moveToElement(subMenu);

        //build()- used to compile all the actions into a single step
        actions.click().build().perform();

        return BasePageFactory.createInstance(driver, SearchResultPage.class);
    }
}
