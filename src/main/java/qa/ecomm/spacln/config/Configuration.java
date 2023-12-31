package qa.ecomm.spacln.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties", "classpath:config.properties"})
public interface Configuration extends Config {

    @Key("browser")
    String browser();

    @Key("headless")
    Boolean headless();

    @Key("timeout")
    int timeout();

    // application URLs ---------------------------------
    @Key("base.url")
    String baseUrl();

    @Key("base.myaccount.url")
    String myAccountUrl();
    // application URLs ---------------------------------


    @Key("base.test.data.path")
    String baseTestDataPath();

    @Key("base.report.path")
    String baseReportPath();

    @Key("base.screenshot.path")
    String baseScreenshotPath();
}
