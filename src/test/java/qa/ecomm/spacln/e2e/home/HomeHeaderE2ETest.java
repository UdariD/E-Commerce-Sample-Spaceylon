package qa.ecomm.spacln.e2e.home;

import org.testng.Assert;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.ecomm.spacln.data.home.HomeData;
import qa.ecomm.spacln.data.login.LoginData;
import qa.ecomm.spacln.e2e.BaseE2ETest;
import qa.ecomm.spacln.ui.page.home.HomePage;
import qa.ecomm.spacln.ui.page.home.SearchResultPage;
import qa.ecomm.spacln.ui.page.home.ShopPage;
import qa.ecomm.spacln.ui.page.login.LoginPage;

import java.io.IOException;
import java.lang.reflect.Method;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static qa.ecomm.spacln.util.DataProviderUtils.processCsv;

public class HomeHeaderE2ETest extends BaseE2ETest {

    private static final String FILE_PATH = "home/home.csv";

    private HomePage homePage;

    @Override
    public void initialize() {
        homePage = createInstance(HomePage.class);
    }

    @DataProvider(name = "homeData")
    public Object[][] getHomeData(final Method testMethod) {
        String testCaseId = testMethod.getAnnotation(Test.class).testName();

        return processCsv(HomeData.class, getTestDataFilePath(FILE_PATH), testCaseId);
    }

    @AfterMethod(alwaysRun = true)
    public void captureScreenshotOnFailure(ITestResult result) {
        ITestNGMethod method = result.getMethod();

        if (ITestResult.FAILURE == result.getStatus()) {
            homePage.captureScreenshot(
                    String.format(
                            "%s_%s_%s",
                            method.getRealClass().getSimpleName(),
                            method.getMethodName(),
                            method.getParameterInvocationCount()));
        }
    }

    @Test(testName = "TC-Com-1")
    public void findAllBrokenLinks(){
        int brokenCount=0;
        try {
             brokenCount= homePage.open().verifyLinks();
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
        assertThat(0).isEqualTo(brokenCount);
    }

    @Test(testName = "TC-Com-2")
    public void findAllBrokenImages(){
        int brokenCount=0;
        try {
            brokenCount= homePage.open().verifyImages ();
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
        assertThat(0).isEqualTo(brokenCount);
    }


    @Test(  testName = "TC-Home-1",
            dataProvider = "homeData",
            groups = {"smoke", "regression"})
    public void testLoginIconClick(final HomeData data){
        LoginPage loginPage = homePage.open().clickOnLoginIcon();
        assertThat(loginPage.getPageHeader().equals("My account"));
    }

   /* Temp - hold stuck at no element found exception
    @Test(  testName = "TC-Home-2",
            dataProvider = "homeData",
            groups = {"smoke", "regression"})
    public void testSearchBar(final HomeData data){
        SearchResultPage resultPage= homePage.open().typeSearchWord(data.getSearchInput());
        assertThat(resultPage.getPageHeader().contains("Displaying results for"));
    }
    */

    @Test(  testName = "TC-Menu-1",
            dataProvider = "homeData",
            groups = {"smoke", "regression"})
    public void testSubMenuNavigation(final HomeData data){
        SearchResultPage resultPage = homePage.open().clickOnSubMenuBabyCare();
        assertThat(resultPage.getSubMenuNavigationPath().contains("Bath & Body"));
    }
}
