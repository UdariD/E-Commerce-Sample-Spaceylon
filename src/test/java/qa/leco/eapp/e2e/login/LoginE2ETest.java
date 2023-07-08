package qa.leco.eapp.e2e.login;

import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.leco.eapp.data.login.LoginData;
import qa.leco.eapp.e2e.BaseE2ETest;
import qa.leco.eapp.page.home.HomePage;
import qa.leco.eapp.page.login.LoginPage;

import java.lang.reflect.Method;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static qa.leco.eapp.util.DataProviderUtils.processCsv;

public class LoginE2ETest extends BaseE2ETest {

    private static final String FILE_PATH = "login/login.csv";
    private LoginPage loginPage;

    @DataProvider(name = "loginData")
    public Object[][] getLoginData(final Method testMethod) {
        String testCaseId = testMethod.getAnnotation(Test.class).testName();

        return processCsv(LoginData.class, getTestDataFilePath(FILE_PATH), testCaseId);
    }

    @Override
    public void initialize() {
        loginPage = createInstance(LoginPage.class);
    }

    @AfterMethod(alwaysRun = true)
    public void captureScreenshotOnFailure(ITestResult result) {
        ITestNGMethod method = result.getMethod();

        if (ITestResult.FAILURE == result.getStatus()) {
            loginPage.captureScreenshot(
                    String.format(
                            "%s_%s_%s",
                            method.getRealClass().getSimpleName(),
                            method.getMethodName(),
                            method.getParameterInvocationCount()));
        }
    }

    @Test(
            testName = "TC-1",
            dataProvider = "loginData",
            groups = {"smoke", "regression"})
    public void testCorrectUserNameAndCorrectPassword(final LoginData data) {
        loginPage
                .open()
                .typeUsername(data.getUserName())
                .typePassword(data.getPassword())
                .clickOnLogin();

        HomePage homePage = createInstance(HomePage.class);

        assertThat(homePage.getTitle()).isEqualTo("Leco Bungalow Reservation System");
    }

    @Test(
            testName = "TC-2",
            dataProvider = "loginData",
            groups = {"regression"})
    public void testIncorrectUserNameAndCorrectPassword(final LoginData data) {
        loginPage
                .open()
                .typeUsername(data.getUserName())
                .typePassword(data.getPassword())
                .clickOnLogin();

        assertThat(loginPage.getErrorMessage()).isEqualTo(data.getErrorMessage());
    }
/*
    @Test(
            testName = "TC-3",
            dataProvider = "loginData",
            groups = {"regression"})
    public void testCorrectUserNameAndIncorrectPassword(final LoginData data) {
        loginPage
                .open()
                .typeUsername(data.getUserName())
                .typePassword(data.getPassword())
                .clickOnLogin();

        assertThat(loginPage.getErrorMessage()).isEqualTo(data.getErrorMessage());
    }
*/
    @Test(
            testName = "TC-4",
            dataProvider = "loginData",
            groups = {"regression"})
    public void testIncorrectUserNameAndIncorrectPassword(final LoginData data) {
        loginPage
                .open()
                .typeUsername(data.getUserName())
                .typePassword(data.getPassword())
                .clickOnLogin();

        assertThat(loginPage.getErrorMessage()).isEqualTo(data.getErrorMessage());
    }
/*
    @Test(
            testName = "TC-5",
            dataProvider = "loginData",
            groups = {"regression"})
    public void testBlankUserName(final LoginData data) {
        loginPage.open().typePassword(data.getPassword()).clickOnLogin();

        assertThat(loginPage.getErrorMessage()).isEqualTo(data.getErrorMessage());
    }

    @Test(
            testName = "TC-6",
            dataProvider = "loginData",
            groups = {"regression"})
    public void testBlankPassword(final LoginData data) {
        loginPage.open().typeUsername(data.getUserName()).clickOnLogin();

        assertThat(loginPage.getErrorMessage()).isEqualTo(data.getErrorMessage());
    }

    @Test(
            testName = "TC-7",
            dataProvider = "loginData",
            groups = {"regression"})
    public void testLockedOutUser(final LoginData data) {
        loginPage
                .open()
                .typeUsername(data.getUserName())
                .typePassword(data.getPassword())
                .clickOnLogin();

        assertThat(loginPage.getErrorMessage()).isEqualTo(data.getErrorMessage());
    }

 */
}
