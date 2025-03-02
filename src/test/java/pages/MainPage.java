package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final WebDriver driver;

    // Web element
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/a")
    private WebElement signIn;

    // Constructor
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Sign in method
    public void signIn() {
        signIn.click();
    }
}
