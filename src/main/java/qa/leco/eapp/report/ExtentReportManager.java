package qa.leco.eapp.report;

import static qa.leco.eapp.config.ConfigurationManager.config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {
    private ExtentReportManager() {}

    public static ExtentReports createReport() {
        String currentDate = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
        String fileName =
                String.format("%sEAPP_TestReport_%s.html", config().baseReportPath(), currentDate);

        ExtentReports extentReport = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(fileName);

        spark.config().setTimeStampFormat("dd MMM yyyy HH:mm:ss z");
        spark.config().setTimelineEnabled(false);

        extentReport.attachReporter(spark);
        extentReport.setSystemInfo("Platform", System.getProperty("os.name"));
        extentReport.setSystemInfo("Version", System.getProperty("os.version"));
        extentReport.setSystemInfo("Browser", StringUtils.capitalize(config().browser()));
        extentReport.setSystemInfo("Context URL", config().baseUrl());
        extentReport.setSystemInfo(
                "Test Group",
                StringUtils.capitalize(
                        StringUtils.defaultString(System.getProperty("groups"), "regression")));

        return extentReport;
    }
}
