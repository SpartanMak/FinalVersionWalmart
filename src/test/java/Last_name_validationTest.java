import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import static org.testng.Assert.assertTrue;

public class Last_name_validationTest extends BaseTest {

    @Title("Testing Last name validation")
    @Test
    public void testLastNameValidation() {
        System.out.println("Step 14: Enter Last name in field ");
        WebElement lastNameInputField = webDriver.findElement(By.xpath("//input[@name = 'lastName']"));

        //Check the Last name field by not filling any data
        lastNameInputField.clear();
        lastNameInputField.sendKeys("");
        website.signupPage().clickLoginButton();
        assertTrue(website.signupPage().lastNameValidation().contains("Last name is required."));

        //Check the Last name field by > 25 characters
        lastNameInputField.clear();
        lastNameInputField.sendKeys("Rhoshandiatellyneshzxsafas");
        website.signupPage().clickLoginButton();
        assertTrue(website.signupPage().lastNameValidation().contains("Please enter a valid last name."));

        //Check the Last name field by multi language first name
        lastNameInputField.clear();
        lastNameInputField.sendKeys("Александр");
        website.signupPage().clickLoginButton();
        assertTrue(website.signupPage().lastNameValidation().contains("Please enter a valid last name."));

        //Check the Last name field by special characters
        lastNameInputField.clear();
        lastNameInputField.sendKeys("Loud&Clear");
        website.signupPage().clickLoginButton();
        assertTrue(website.signupPage().lastNameValidation().contains("Please enter a valid last name."));

        //Check the Last name field by SQL Injection
        lastNameInputField.clear();
        lastNameInputField.sendKeys("Robert'); DROP TABLE Users;--");
        website.signupPage().clickLoginButton();
        assertTrue(website.signupPage().lastNameValidation().contains("Please enter a valid last name."));


    }
}

