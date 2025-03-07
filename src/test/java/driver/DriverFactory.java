package driver;

import com.opencsv.CSVReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

    @BeforeTest
    public void registration() {
        driver.get("""
                https://magento.softwaretestingboard.com/""");
    }

    // Quit the finished browser
    @AfterMethod(alwaysRun = true)
    public void driverTearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
