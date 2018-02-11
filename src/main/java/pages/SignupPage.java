package pages;

import org.openqa.selenium.WebDriver; // 1 - Only WebDriver
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver; // 2 - Only RemoteWebDriver
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;


public class SignupPage {
  //  private RemoteWebDriver webDriver; // 2 - Only RemoteWebDriver
    private WebDriver webDriver; // 1 - Only WebDriver
    private WebDriverWait wait;

    public SignupPage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);

        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//input[@data-tl-id = 'signup-first-name-input']")
    WebElement firstNameInputField;

    @FindBy(xpath = "//input[@name = 'lastName']")
    WebElement lastNameInputField;

    @FindBy(xpath = "//input[@type = 'email']")
    WebElement emailInputField;

    @FindBy(xpath = "//input[@name = 'password']")
    WebElement passwordInputField;

    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement loginButton;

    @FindBy(id = "checkbox-0")
    WebElement RememberMeCheckbox;


    @FindBy(linkText = "Terms of Use")
    WebElement TermsofUseLink;


    @FindBy(linkText = "Privacy Policy")
    WebElement PrivacyPolicyLink;

    @FindBy(xpath = "//span[2][@data-reactid = '.0.0.1.0.1.3.4.0.1.1']")
    WebElement emailValidation;

    @FindBy(className = "validation-marker-success")
    WebElement emailMarkerSuccess;

    @FindBy(xpath = "//span[2][@data-reactid = '.0.0.1.0.1.3.5.0.0.0.1.1']")
    WebElement passwordValidation;

    @FindBy(className = "validation-marker-success")
    WebElement passwordMarkerSuccess;

    @FindBy(className = "ada-error-text")
    WebElement firstNameValidation;

    @FindBy(xpath = "//span[2][@data-reactid = '.0.0.1.0.1.3.3.0.1.1']")
    WebElement lastNameValidation;

    @Step("Input First Name")
    public void enterCredentialsFirstName (String text){
        firstNameInputField.clear();
        firstNameInputField.sendKeys("Alexandr");

    }

    @Step("Input Last Name")
    public void enterCredentialsLastName (String text){
        lastNameInputField.clear();
        lastNameInputField.sendKeys("Makarov");

    }
    @Step("Input Email")
    public void enterCredentialsEmail (String text){



            int a = (int) (Math.random() * 10000);

            emailInputField.clear();
            emailInputField.sendKeys("spartanluvatar+" + a + "@gmail.com");

    }


    @Step("Input Password")
    public void enterCredentialsPassword (String text){
        passwordInputField.clear();
        passwordInputField.sendKeys("qwerty1234");

    }


        @Step("Click checkbox RememberMe")
        public void setRememberMeCheckbox () {
            if (RememberMeCheckbox.isSelected())
            { System.out.println("RememberMeCheckbox - is selected"); }
            else {
                System.out.println("RememberMeCheckbox - is not selected");
                RememberMeCheckbox.click();}
        }


    @Step("Click on Create Account button")
    public void clickLoginButton () {
        loginButton.click();
    }



    @Step("Click on TermsofUseLink link")
    public void TermsofUseLink () {
        TermsofUseLink.click();
    }


    @Step("Click on PrivacyPolicyLink link")
    public void PrivacyPolicyLink () {
        PrivacyPolicyLink.click();
    }

    @Step("Check the Email field by all the invalid emails")
    public String emailValidation () {
        return emailValidation.getText();
    }

    @Step("Check the Password field by all the invalid password")
    public String passwordValidation () {
        return passwordValidation.getText();
    }

    @Step("Check the first name field by all the invalid first name")
    public String firstNameValidation () {
        return firstNameValidation.getText();
    }

    @Step("Check the last name field by all the invalid last name")
    public String lastNameValidation () {
        return lastNameValidation.getText();
    }

    @Step("Check the Email field by valid emails")
    public void emailMarkerSuccess () {

        if (emailMarkerSuccess.isDisplayed()) {
            System.out.println("Step 16: Correct email");
        } else {
            System.out.println("Step 16: Incorrect email");
        }
    }

    @Step("Check the password field by valid emails")
    public void passwordMarkerSuccess () {

        if (passwordMarkerSuccess.isDisplayed()) {
            System.out.println("Step 18: Correct password");
        } else {
            System.out.println("Step 16: Incorrect password");
        }
    }
}
