package qa.ecomm.spacln.e2e.home;

import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import qa.ecomm.spacln.e2e.BaseE2ETest;
import qa.ecomm.spacln.ui.page.home.ShopPage;

public class ShopPageE2ETest extends BaseE2ETest {

    private ShopPage shopPage;

    @Override
    public void initialize() {
        shopPage = createInstance(ShopPage.class);
    }

    @AfterMethod(alwaysRun = true)
    public void captureScreenshotOnFailure(ITestResult result) {
        ITestNGMethod method = result.getMethod();

        if (ITestResult.FAILURE == result.getStatus()) {
            shopPage.captureScreenshot(
                    String.format(
                            "%s_%s_%s",
                            method.getRealClass().getSimpleName(),
                            method.getMethodName(),
                            method.getParameterInvocationCount()));
        }
    }

    ///
    @Test(testName = "TC-Com-3")
    public void shopItemOrderBy()
    {
        shopPage.open().changeOrderBy();
    }
}
