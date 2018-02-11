
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;

public class TestListener extends BaseTest implements ITestListener {

    private static String getTesMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    //Text attachments for Allure
    @Attachment(value = "Screen screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver webDriver) {
        return ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BYTES);
    }

/*    //Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plane")
    public static String saveTextLog(String message){
        return message;
    }

    //HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

        System.out.println("Let's go start! " + getTesMethodName(iTestResult));

        //Get driver from TestBase and assign to local WebDriver variable.
        Object testClass = iTestResult.getInstance();
        RemoteWebDriver webDriver = ((BaseTest) testClass).getInitDriver();

        //Allure Screenshot and SaveTestLog
        if (webDriver != null) {
            System.out.println("Screenshot captured for test case: " + getTesMethodName(iTestResult));
            saveScreenshotPNG(webDriver);
        }
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        System.out.println("Test success! Congratulation!");

        //Get driver from TestBase and assign to local WebDriver variable.
        Object testClass = iTestResult.getInstance();
        RemoteWebDriver webDriver = ((BaseTest) testClass).getInitDriver();

        //Allure Screenshot and SaveTestLog
        if (webDriver != null) {
            System.out.println("Screenshot captured for test case: " + getTesMethodName(iTestResult));
            saveScreenshotPNG(webDriver);
        }
    }*/



    @Override
    public void onTestFailure(ITestResult iTestResult) {

        System.out.println("Hi! I am in onTestFailure. Method " + getTesMethodName(iTestResult) + " failed");

        //Get driver from TestBase and assign to local WebDriver variable.
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getInitDriver();

        //Allure Screenshot and SaveTestLog
        if (webDriver != null) {
            System.out.println("Screenshot captured for test case: " + getTesMethodName(iTestResult));
            saveScreenshotPNG(webDriver);
        }

/*        //Save a log on Allure
        saveTextLog(getTesMethodName(iTestResult) + " failed and screenshot taken!");
        attachHtml(getTesMethodName(iTestResult));*/
    }

   //УДАЛИТЬ ЕСЛИ ПРИКРЕПЛЯТЬ СКРИНЫ И ЛОГИ КО ВСЕМУ
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }
    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

/*    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }*/
}
