package pages;

import org.openqa.selenium.WebDriver; // 1 - Only WebDriver
//import org.openqa.selenium.remote.RemoteWebDriver; // 2 - Only RemoteWebDriver

public class SiteMap {
    WebDriver webDriver; // 1 - Only WebDriver
//  public RemoteWebDriver webDriver; // 2 - Only RemoteWebDriver

    public SiteMap(WebDriver driver) {
        webDriver = driver;
    }  // 1 - Only WebDriver

/*    public SiteMap(RemoteWebDriver driver) {
        webDriver = driver;
    }*/  // 2 - Only RemoteWebDriver

    public MainPage mainPage() { return new MainPage(webDriver);}

    public SignupPage signupPage() { return new SignupPage(webDriver);}

    public ResetPage resetPage() { return new ResetPage(webDriver);}


}
