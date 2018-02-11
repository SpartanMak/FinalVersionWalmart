package pages;

import org.openqa.selenium.WebDriver; // 1 - Only WebDriver
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver; // 2 - Only RemoteWebDriver
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class ResetPage {
  //      private RemoteWebDriver webDriver; // 2 - Only RemoteWebDriver
    private WebDriver webDriver; // 1 - Only WebDriver
    private WebDriverWait wait;

    public ResetPage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);

        PageFactory.initElements(webDriver, this);
    }
    @FindBy(xpath = "//button[@data-tl-id = 'forgotpwd-submit-btn']")
    WebElement resetButton;

    @FindBy(className = "ada-error-text")
    WebElement resetPasswordTextFalse;

    @FindBy(xpath = "//input[@name = 'email']")
    WebElement resetPasswordTextTrue;

    @FindBy(xpath = "//button[@data-tl-id = 'signin-forgot-password-link-btn']")
    WebElement forgotPasswordLink;

    @Step("Get Forgot your password text")
    public String forgotText () {
        return forgotPasswordLink.getText();
    }

    @Step("Click on reset button")
    public void clickResetButton() {
        resetButton.click();
    }

    @Step("Get Forgot your password text false")
    public String resetTextFalse() {
        return resetPasswordTextFalse.getText();
    }

    @Step("Get Forgot your password text true")
    public String resetTextTrue() {
        return resetPasswordTextTrue.getAttribute("value");
    }

    @Step("Click on forgot password link")
    public void forgotPasswordLink () {
        forgotPasswordLink.click();
    }

}
