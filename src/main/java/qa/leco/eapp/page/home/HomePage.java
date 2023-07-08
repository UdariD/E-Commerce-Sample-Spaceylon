package qa.leco.eapp.page.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.leco.eapp.page.BasePage;

public final class HomePage extends BasePage {
    @FindBy(xpath = "//*[@id=\"mimin\"]/nav/div/div/a/b")
    private WebElement lblTitle;

    public String getTitle() {
        return lblTitle.getText();
    }
}
