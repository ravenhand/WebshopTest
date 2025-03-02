package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final WebDriver driver;

    @FindBy(xpath = "//*[contains(text(),'Sign In')]")
    private WebElement signIn;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void signIn() {
        signIn.click();
    }
}
