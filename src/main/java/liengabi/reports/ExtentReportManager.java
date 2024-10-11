package liengabi.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {  //Khởi tạo thông số đầu ra của report
        ExtentSparkReporter reporter = new ExtentSparkReporter("reports/ExtentReport/ExtentReport.html");
        reporter.config().setReportName("Extent Report | Lien Gabi");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Framework Name", "Selenium Java | Lien Gabi");
        extentReports.setSystemInfo("Author", "Lien Gabi");
        return extentReports;
    }

}
