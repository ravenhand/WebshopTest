package tests;

import driver.DriverFactory;
import org.testng.annotations.Test;
import pages.MainPage;

public class SignInTest extends DriverFactory {

    @Test
    public void signingIn() {
        MainPage mainPage = new MainPage(driver);
        mainPage.signIn();
    }
}
