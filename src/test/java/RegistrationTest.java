import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Title;


import static org.testng.Assert.assertTrue;


//@Listeners({TestListener.class})


public class RegistrationTest extends BaseTest {

    @Title("Testing registration user")
    @Test(priority = 1)
    public void testRegistrationUser() {
        System.out.println("Step 1: Enter Credentials First name");
        website.signupPage().enterCredentialsFirstName("firstName");

        System.out.println("Step 2: Enter Credentials Last name");
        website.signupPage().enterCredentialsLastName("lastName");

        System.out.println("Step 3: Enter Credentials email");
        website.signupPage().enterCredentialsEmail("email");

        System.out.println("Step 4: Enter Credentials password");
        website.signupPage().enterCredentialsPassword("password");

        System.out.println("Step 5: Check Remember Me");
        website.signupPage().setRememberMeCheckbox();

        System.out.println("Step 6: Click login button");
        website.signupPage().clickLoginButton();
    }
    @Title("Testing login user")
    @Test(priority = 2)
    public void testLoginUser() {
        System.out.println("Step 7: Login user");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ellipsify-name")));
        website.mainPage().toggleSidebar();
        Assert.assertTrue(webDriver.getCurrentUrl().contains("https://www.walmart.com/account/?action=Create&rm=true"));
        assertTrue(website.mainPage().helloText().contains("Alexandr"));
    }

    @Title("Testing logout user")
    @Test(priority = 3)
    public void testLogoutUser() {
        System.out.println("Step 9: Logout user");
        website.mainPage().clickMenuButton();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Not You? Sign Out")));
        website.mainPage().clickLogoutButton();
        Assert.assertTrue(webDriver.getCurrentUrl().contains("https://www.walmart.com/account/login?ref=domain"));
        assertTrue(website.resetPage().forgotText().contains("Forgot password?"));
    }

    @Title("Testing Forgot your password button")
    @Test(priority = 4)
    public void testResetPassword (){
        System.out.println("Step 10: Click Forgot your password link");
        website.resetPage().forgotPasswordLink();
        Assert.assertTrue(webDriver.getCurrentUrl().contains("https://www.walmart.com/account/forgotpassword?ref=domain"));

        System.out.println("Step 11: Click Send Password Reset Link without email");
        website.resetPage().clickResetButton();
        assertTrue(website.resetPage().resetTextFalse().contains("Email address is required."));

        System.out.println("Step 12: Click Send Password Reset Link with email");
        website.signupPage().enterCredentialsEmail("email");
        website.resetPage().clickResetButton();
        assertTrue(website.resetPage().resetTextTrue().contains("spartanluvatar"));

    }
}



