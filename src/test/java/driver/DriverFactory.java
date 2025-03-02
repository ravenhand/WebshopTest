package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.Random;

public class DriverFactory {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    public void setupDriverFactory() {
        /* ------ configuration starts ------ */
        Random random = new Random();
        int driverNumber = random.nextInt(1, 4);
        switch (driverNumber) {
            case 1:
                driver = new ChromeDriver();
                break;
            case 2:
                driver = new FirefoxDriver();
                break;
            case 3:
                driver = new EdgeDriver();
                break;
        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(10000)); // megadott sec-ig várakozik az oldal betöltésére
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000)); // megadott sec-ig várakozik, hogy a megadott elemeknek legyen elég ideje megjelenni

        // Explicit wait beállítás
        wait = new WebDriverWait(driver, Duration.ofMillis(10000)); // változót hoz létre a várakozáshoz, 10 sec maximum
        /* ------ configuration ends ------ */
    }

    /*@BeforeTest
    public void registration() {
        driver.get("""
                https://magento.softwaretestingboard.com/""");


    }
    */

    // Quit the finished browser
    @AfterMethod(alwaysRun = true)
    public void driverTearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
