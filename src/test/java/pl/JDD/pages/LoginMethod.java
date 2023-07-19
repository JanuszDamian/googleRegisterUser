package pl.JDD.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginMethod {

    @FindBy(xpath = "//div[text()='Utwórz własny adres Gmail']")
    private WebElement radioOwnAddressEmail;

    @FindBy(name = "Username")
    private WebElement userNameInput;

    @FindBy(xpath = "//span[text()='Dalej']")
    private WebElement dalejButton;

    @FindBy(xpath = "//span[text()='Wybierz adres Gmail lub utwórz własny']")
    private WebElement dashboardText;

    public WebDriver driver;

    public LoginMethod(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void writeLogin() {
        int randomNumber = (int) (Math.random() * 1000);
        userNameInput.sendKeys("rewhqwet" + randomNumber);
        dalejButton.click();
    }

    public CreatePasswordPage openCreatePasswordPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(radioOwnAddressEmail));

        if (radioOwnAddressEmail.isDisplayed()) {
            radioOwnAddressEmail.click();
            writeLogin();
        } else {
            writeLogin();
        }

        return new CreatePasswordPage(driver);
    }

}
