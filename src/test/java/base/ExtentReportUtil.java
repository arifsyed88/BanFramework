package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class ExtentReportUtil extends BaseUtil {

    String fileName = reportLocation + "extentreport.html";

    public void ExtentReport() {
        //Create Extent Reports object
        extent = new ExtentReports();

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Test report for Selenium BAN");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Test Report");

        extent.attachReporter(htmlReporter);
    }

    public void ExtentReportScreenshot() throws IOException {
        var scr = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
        Files.copy(scr.toPath(),new File(reportLocation + "screenshot.png").toPath());
//        scenarioDef.fail()

    }

    public void FlushReport() {
        extent.flush();
    }


}
