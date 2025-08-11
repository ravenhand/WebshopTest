package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    // Web element
    @FindBy(className = "input")
    private WebElement userName;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"loginPanel\"]/form/div[3]/input")
    private WebElement logIn;

    // Constructor
    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    //Sign in method
    public void addUsername(String username) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(userName));
        element.sendKeys(username);
    }

    public void addPassword(String pw) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(password));
        element.sendKeys(pw);
    }

    public void clickLogin() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(logIn));
        element.click();
    }
}
