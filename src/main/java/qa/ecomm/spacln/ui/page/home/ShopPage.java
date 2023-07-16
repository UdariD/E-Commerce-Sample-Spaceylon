package qa.ecomm.spacln.ui.page.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import qa.ecomm.spacln.config.ConfigurationManager;
import qa.ecomm.spacln.ui.page.BasePage;

import java.util.List;

public class ShopPage extends BasePage {


    @FindBy(name = "orderby")
    private WebElement dropDwnorderby;


    public ShopPage open() {
        driver.get(ConfigurationManager.config().baseUrl());
        driver.findElement(By.xpath("//*[@id=\"menu-item-494062\"]/a")).click();
        return this;
    }

    public void changeOrderBy()
    {
        // Create object of the Select class
        Select se = new Select (dropDwnorderby);

        //Get list of web elements
        List<WebElement> lst = se.getOptions();
        //Looping through the options and printing dropdown options
        System.out.println("The dropdown options are:");
        for(WebElement options: lst)
            System.out.println(options.getText());

        // Select the option by index
        se.selectByIndex(3);
    }
}