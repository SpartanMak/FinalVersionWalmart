import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import static org.testng.Assert.assertTrue;

public class First_name_validationTest extends BaseTest {

    @Title("Testing First name validation")
    @Test
    public void testFirstNameValidation() {
        System.out.println("Step 13: Enter First name in field ");
        WebElement firstNameInputField = webDriver.findElement(By.xpath("//input[@data-tl-id = 'signup-first-name-input']"));

        //Check the First name field by not filling any data
        firstNameInputField.clear();
        firstNameInputField.sendKeys("");
        website.signupPage().clickLoginButton();
        assertTrue(website.signupPage().firstNameValidation().contains("First name is required."));

        //Check the First name field by > 25 characters
        firstNameInputField.clear();
        firstNameInputField.sendKeys("Rhoshandiatellyneshzxsafas");
        website.signupPage().clickLoginButton();
        assertTrue(website.signupPage().firstNameValidation().contains("Please enter a valid first name."));

        //Check the First name field by multi language first name
        firstNameInputField.clear();
        firstNameInputField.sendKeys("Александр");
        website.signupPage().clickLoginButton();
        assertTrue(website.signupPage().firstNameValidation().contains("Please enter a valid first name."));

        //Check the First name field by special characters
        firstNameInputField.clear();
        firstNameInputField.sendKeys("Loud&Clear");
        website.signupPage().clickLoginButton();
        assertTrue(website.signupPage().firstNameValidation().contains("Please enter a valid first name."));

        //Check the First name field by SQL Injection
        firstNameInputField.clear();
        firstNameInputField.sendKeys("Robert'); DROP TABLE Users;--");
        website.signupPage().clickLoginButton();
        assertTrue(website.signupPage().firstNameValidation().contains("Please enter a valid first name."));


    }
}
