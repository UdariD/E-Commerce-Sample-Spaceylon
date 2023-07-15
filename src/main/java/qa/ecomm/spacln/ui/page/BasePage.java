package qa.ecomm.spacln.ui.page;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import qa.ecomm.spacln.config.ConfigurationManager;
import qa.ecomm.spacln.ui.page.component.HeaderComponent;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

/*
 * This class defines the basic functionalities of a POM class.
 */

public class BasePage {
    protected WebDriver driver;

    public HeaderComponent headerComponent;

    public void initialize(final WebDriver webdriver) {
        this.driver = webdriver;
        //IP driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
       //IP  PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
        headerComponent = new HeaderComponent(driver);
    }

    public void captureScreenshot(String fileName) {
        Shutterbug.shootPage(driver).withName(fileName).save(ConfigurationManager.config().baseScreenshotPath());
    }

    private static boolean isUrlValid(String url) {
        try {
            URL obj = new URL(url);
            obj.toURI();
            return true;
        } catch (MalformedURLException e) {
            return false;
        } catch (URISyntaxException e) {
            return false;
        }
    }
    public int verifyImages() throws IOException {
        int brokencnt=0;
        // Storing all elements with img tag in a list of WebElements
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Total number of Images on the Page are " + images.size());


        //checking the links fetched.
        for(int i=0;i<10;i++)
        {
            WebElement image= images.get(i);
            String imageURL= image.getAttribute("src");
            System.out.println("URL of Image " + (i+1) + " is: " + imageURL);
            //verifyLinks(imageURL);

            //Validate image display using JavaScript executor
            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript("return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);", image);
                if (imageDisplayed) {
                    System.out.println("DISPLAY - OK");
                }else {
                    System.out.println("DISPLAY - BROKEN");
                }
            }
            catch (Exception e) {
                System.out.println("Error Occured");
            }
        }
        return brokencnt;
    }
    public int verifyLinks() throws IOException {

        // Store all link elements (anchor tag elements in html) in a list
        List<WebElement> links = driver.findElements(By.tagName("a"));
        int brokencnt=0 , invalidcnt=0;
        for (int i = 1; i<=10; i=i+1)
        {
            // Get href attribute
            WebElement elem = links.get(i);
            String websiteLink =elem.getAttribute ("href");
            if(isUrlValid(websiteLink)) {
                // Create URL object and pass website link
                URL url = new URL (websiteLink);

                // Create URL connection and Get the response code
                HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection ();
                httpURLConnect.setConnectTimeout (5000);
                httpURLConnect.connect ();

                // Verify Response code
                if (httpURLConnect.getResponseCode () >= 400) {
                    System.out.println ("[" + i + "] " + websiteLink + " - "
                            + httpURLConnect.getResponseMessage () + " - is a broken link");
                    brokencnt = brokencnt++;
                }
                //Fetching and Printing the response code obtained
                else {
                    System.out.println ("[" + i + "] " + websiteLink + " - " + httpURLConnect.getResponseMessage ());
                }
                // Disconnect URL Connection
                httpURLConnect.disconnect ();
            }else{invalidcnt=invalidcnt++;}

        }
        System.out.println("Total links =" +links.size()+ " Invalid links = "+invalidcnt+ " Broken links = "+brokencnt);
        return brokencnt;
    }


}
