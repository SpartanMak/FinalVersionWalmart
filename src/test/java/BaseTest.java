
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; // 1 - Only WebDriver
import org.openqa.selenium.chrome.ChromeDriver; // 1 - Only WebDriver
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver; // 2 - Only RemoteWebDriver
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.SiteMap;
import ru.yandex.qatools.allure.annotations.Title;

import java.net.MalformedURLException;
import java.net.URL; // 2 - Only RemoteWebDriver

import static com.google.common.base.Preconditions.checkNotNull;
import static org.testng.Assert.assertTrue;


public class BaseTest {
    //    public  RemoteWebDriver webDriver; // 2 - Only RemoteWebDriver
    WebDriver webDriver; // 1 - Only WebDriver
    SiteMap website;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setJavascriptEnabled(true);
     /*   webDriver = new RemoteWebDriver((new URL(
                "http://138.197.185.28:4444/wd/hub")), capabilities); */ // 2 - Only RemoteWebDriver
     /*   webDriver = new RemoteWebDriver((new URL(
                "http://localhost:4444/wd/hub")), capabilities);*/ //3 - Selenium StandAlone

        webDriver = new ChromeDriver(); // 1 - Only WebDriver
        webDriver.manage().window().maximize();
        wait = new WebDriverWait(webDriver, 30, 500);

        website = new SiteMap(webDriver);

        webDriver.get("https://www.walmart.com/account/signup");


    }

    public WebDriver getInitDriver() {
        return checkNotNull(webDriver,
                "WebDriver not initialized - "
                        + "you are calling webDriver before or "
                        + "after browser was opened or closed");
    }

    @AfterClass
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit();
    }

}
