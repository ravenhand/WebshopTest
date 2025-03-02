package tests;

import driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerLoginPage;
import pages.MainPage;

public class SignInTest extends DriverFactory {

    @Test()
    public void signingIn() {
        MainPage mainPage = new MainPage(driver);
        mainPage.signIn();

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver, wait);

        Assert.assertTrue(driver.getPageSource().contains("If you have an account, sign in with your email address."));
        customerLoginPage.sendEmail("elek_85@freemail.hu");
        customerLoginPage.sendPassword("elek_1985");
        customerLoginPage.clickSignInButton();
        Assert.assertTrue(driver.getPageSource().contains("Home Page"));
    }
}
