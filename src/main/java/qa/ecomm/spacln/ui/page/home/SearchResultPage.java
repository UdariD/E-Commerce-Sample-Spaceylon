package qa.ecomm.spacln.ui.page.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.ecomm.spacln.ui.page.BasePage;

public class SearchResultPage extends BasePage {

    public  String getPageHeader(){
        return driver.findElement(By.tagName("h1")).getText();
    }

    public  String getSubMenuNavigationPath(){
        return driver.findElement (By.xpath ("/html/body/div[2]/div/div[1]/div")).getText ();
    }

}
