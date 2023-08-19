package qa.ecomm.spacln.e2e.login;

import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.ecomm.spacln.data.login.LoginData;
import qa.ecomm.spacln.data.login.RegData;
import qa.ecomm.spacln.e2e.BaseE2ETest;
import qa.ecomm.spacln.ui.page.home.HomePage;
import qa.ecomm.spacln.ui.page.login.LoginPage;

import java.lang.reflect.Method;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static qa.ecomm.spacln.util.DataProviderUtils.processCsv;


public class RegE2ETest extends BaseE2ETest {


    private static final String FILE_PATH = "login/reg.csv";

    private LoginPage loginPage;

    @Override
    public void initialize() {
        loginPage = createInstance(LoginPage.class);
    }

    @DataProvider(name = "regData")
    public Object[][] getRegData(final Method testMethod) {
        String testCaseId = testMethod.getAnnotation(Test.class).testName();

        return processCsv(RegData.class, getTestDataFilePath(FILE_PATH), testCaseId);
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

    //*********************** Test Methods ***************************

    @Test(
            testName = "TC-REG-1",
            dataProvider = "regData",
            groups = {"smoke", "regression"})
    public void testRegistrationValidData(final RegData data) {
        LoginPage loginPageWelcom =  loginPage
                .open()
                .typeFirstLastname (data.getFirstName (),data.getLastName ())
                .typePhone (data.getPhone ())
                .typeUserNameReg (data.getUserName ())
                .typeEmail (data.getEmailAddress ())
                .typePasswordReg (data.getPassword ())
                .clickOnRegister();

        assertThat(loginPageWelcom.getWelcomeMessage ().contains (data.getUserName ()));

    }

   /*  @Test(
            testName = "TC-REG-2",
            dataProvider = "regData",
            groups = {"smoke", "regression"})
    public void testInValidEmail(final LoginData data) {
       HomePage homePage =  loginPage
                .open()
                .typeUsername(data.getUserName())
                .typePassword(data.getPassword())
                .clickOnLogin();

        assertThat(homePage.getTitle()).isEqualTo("Home");

    }*/
}
