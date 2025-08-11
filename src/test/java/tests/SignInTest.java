package tests;

import driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.Objects;

public class SignInTest extends DriverFactory {

    @Test()
    public void signingIn() {
        MainPage mainPage = new MainPage(driver, wait);

        mainPage.addUsername("testuser");
        mainPage.addPassword("testpass");
        mainPage.clickLogin();

        Assert.assertTrue(driver.getPageSource().contains("An internal error has occurred and has been logged."));
    }
}
