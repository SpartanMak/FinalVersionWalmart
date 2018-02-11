import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.annotations.Step;

import static org.testng.Assert.assertTrue;

public class Email_validationTest extends BaseTest {

    @Title("Testing Email validation")
    @Test
    public void testEmailValidation() {
        System.out.println("Step 15: Enter Email in field ");
        WebElement emailInputField = webDriver.findElement(By.xpath("//input[@type = 'email']"));

        //Check the Email field by not filling any data
        emailInputField.clear();
        emailInputField.sendKeys("");
        website.signupPage().clickLoginButton();
        assertTrue(website.signupPage().emailValidation().contains("Email address is required."));

        //Check the Email field by all the invalid emails
        emailInputField.clear();
        emailInputField.sendKeys("plainaddress");
        website.signupPage().clickLoginButton();
        assertTrue(website.signupPage().emailValidation().contains("Please enter a valid email address."));

        emailInputField.clear();
        emailInputField.sendKeys("email.domain.com");
        website.signupPage().clickLoginButton();
        assertTrue(website.signupPage().emailValidation().contains("Please enter a valid email address."));

        emailInputField.clear();
        emailInputField.sendKeys("@domain.com");
        website.signupPage().clickLoginButton();
        assertTrue(website.signupPage().emailValidation().contains("Please enter a valid email address."));

        emailInputField.clear();
        emailInputField.sendKeys("#@%^%#$@#$@#.com");
        website.signupPage().clickLoginButton();
        assertTrue(website.signupPage().emailValidation().contains("Please enter a valid email address."));

        //Check the Email field by valid emails
        emailInputField.clear();
        emailInputField.sendKeys("spartanhtc@gmail.com");
        website.signupPage().emailMarkerSuccess();
    }
}
