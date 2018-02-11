package pages;

import org.openqa.selenium.WebDriver; // 1 - Only WebDriver
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver; // 2 - Only RemoteWebDriver
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;


public class MainPage {
  //      private RemoteWebDriver webDriver; // 2 - Only RemoteWebDriver
    private WebDriver webDriver; // 1 - Only WebDriver
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);

        PageFactory.initElements(webDriver, this);
    }


        @FindBy(className = "ellipsify-name")
        WebElement toggleSidebar;

        @FindBy(className = "ellipsify-name")
        WebElement helloUser;

        @FindBy(linkText = "Not You? Sign Out")
        WebElement logoutButton;



        @Step("Get User text")
        public String helloText () {
            return helloUser.getText();
        }


        @Step("Show admin menu")
        public void clickMenuButton () {
            helloUser.click();
        }

        @Step("Click on logout button")
        public void clickLogoutButton () {
            logoutButton.click();
        }

        @Step("Click on sidebar button")
        public void toggleSidebar () {

            if (helloUser.isDisplayed()) {
                System.out.println("Step 8: Sidebar - open");
            } else {
                System.out.println("Step 8: Sidebar - close. Click to open it");
                toggleSidebar.click();
            }
        }


    }
