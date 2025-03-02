package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerLoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Web elements
    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(id = "pass")
    private WebElement passwordField;
    @FindBy(id = "send2")
    private WebElement signInButton;

    // Constructor
    public CustomerLoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    // Methods
    public void sendEmail(String email) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(emailField));
        element.sendKeys(email);
    }

    public void sendPassword(String password) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(passwordField));
        element.sendKeys(password);
    }

    public void clickSignInButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        element.click();
    }

    // Getter
    public WebElement getEmailField() {
        return emailField;
    }

    // Comfort login
    public void login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
    }
}
