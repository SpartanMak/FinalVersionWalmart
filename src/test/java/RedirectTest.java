import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class RedirectTest extends BaseTest {

    @Title("Testing Redirect")
    @Test
    public void testRedirect() {
        System.out.println("Step 19: Redirect test ");
        website.signupPage().TermsofUseLink();

        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
        webDriver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
        Assert.assertTrue(webDriver.getCurrentUrl().contains("https://help.walmart.com/app/answers/detail/a_id/8"));
        webDriver.close();
        webDriver.switchTo().window(tabs.get(0));
        webDriver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);

        website.signupPage().PrivacyPolicyLink();
        ArrayList<String> tabs2 = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs2.get(1));
        webDriver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
        Assert.assertTrue(webDriver.getCurrentUrl().contains("https://corporate.walmart.com/privacy-security/walmart-privacy-policy"));
        webDriver.close();//Закрытие активного таба*/


    }
}
