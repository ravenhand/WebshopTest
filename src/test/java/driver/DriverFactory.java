package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import java.time.Duration;

public class DriverFactory {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeSuite(alwaysRun = true)
    public void setupDriverFactory() {
        /* ------ configuration starts ------ */
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(10000)); // megadott sec-ig várakozik az oldal betöltésére
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000)); // megadott sec-ig várakozik, hogy a megadott elemeknek legyen elég ideje megjelenni

        // Explicit wait setup
        wait = new WebDriverWait(driver, Duration.ofMillis(10000)); // változót hoz létre a várakozáshoz, 10 sec maximum
        /* ------ configuration ends ------ */
    }

    @BeforeTest()
    public void enterPage() {
        driver.get("https://parabank.parasoft.com");
    }

    // Quit the finished browser
    @AfterMethod(alwaysRun = true)
    public void driverTearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
