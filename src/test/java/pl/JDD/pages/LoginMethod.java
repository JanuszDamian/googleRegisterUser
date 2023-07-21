package pl.JDD.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger logger = LogManager.getLogger();

    public WebDriver driver;

    public LoginMethod(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void writeLogin() {
        int randomNumber = (int) (Math.random() * 1000);
        logger.info("Entering the username");
        userNameInput.sendKeys("rewhqwet" + randomNumber);
        logger.info("Entering the username done");
        logger.info("Clicking next button");
        dalejButton.click();
        logger.info("Clicking next button done");
    }

    public CreatePasswordPage openCreatePasswordPage() {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(radioOwnAddressEmail));
            logger.info("Clicking radio button");
            radioOwnAddressEmail.click();
            logger.info("Clicking radio button done");
            writeLogin();
        } catch (Exception e) {
            writeLogin();
        }
        return new CreatePasswordPage(driver);
    }

}
