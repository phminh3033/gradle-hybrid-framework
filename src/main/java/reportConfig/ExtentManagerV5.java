package reportConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import commons.GlobalConstants;

public class ExtentManagerV5 {
    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(GlobalConstants.RELATIVE_PROJECT_PATH + "/extentReport/HTMLReportV5.html");
        reporter.config().setReportName("FB HTML Report V5");
        reporter.config().setDocumentTitle("FB HTML Report V5");
        reporter.config().setTimelineEnabled(true);
        reporter.config().setEncoding("utf-8");
        reporter.config().setTheme(Theme.STANDARD);

        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Company", "Automation FC");
        extentReports.setSystemInfo("Project", "FB HTML Report V5");
        extentReports.setSystemInfo("Team", "FB Team");
        extentReports.setSystemInfo("JDK version", GlobalConstants.JAVA_VERSION);
        return extentReports;
    }
}