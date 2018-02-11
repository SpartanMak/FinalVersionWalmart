import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import static org.testng.Assert.assertTrue;

public class Password_validationTest extends BaseTest {

    @Title("Testing Password validation")
    @Test
    public void testPasswordValidation() {
        System.out.println("Step 17: Enter Password name in field ");
        WebElement passwordInputField = webDriver.findElement(By.xpath("//input[@name = 'password']"));

        //Check the password field by not filling any data
        passwordInputField.clear();
        passwordInputField.sendKeys("");
        website.signupPage().clickLoginButton();
        assertTrue(website.signupPage().passwordValidation().contains("Password is required."));

        //Check the password field by < 6 characters
        passwordInputField.clear();
        passwordInputField.sendKeys("qwe12");
        website.signupPage().clickLoginButton();
        assertTrue(website.signupPage().passwordValidation().contains("Your password must contain between 6 and 12 characters, with no spaces. Please try again."));

        //Check the password field by > 12 characters
        passwordInputField.clear();
        passwordInputField.sendKeys("qwerty1qwerty");
        website.signupPage().clickLoginButton();
        assertTrue(website.signupPage().passwordValidation().contains("Your password must contain between 6 and 12 characters, with no spaces. Please try again."));

        //Check the password field by space
        passwordInputField.clear();
        passwordInputField.sendKeys("Jon Carter");
        website.signupPage().clickLoginButton();
        assertTrue(website.signupPage().passwordValidation().contains("Your password must contain between 6 and 12 characters, with no spaces. Please try again."));

        //Check the password field by valid emails
        passwordInputField.clear();
        passwordInputField.sendKeys("qwerty1234");
        website.signupPage().passwordMarkerSuccess();
    }
}