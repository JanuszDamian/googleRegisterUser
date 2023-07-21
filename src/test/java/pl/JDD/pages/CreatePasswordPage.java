package pl.JDD.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePasswordPage {

    @FindBy(name = "Passwd")
    private WebElement passwordInput;

    @FindBy(name = "PasswdAgain")
    private WebElement passwordConfirmInput;

    @FindBy(xpath = "//span[text()='Dalej']")
    private WebElement dalejButton;

    private static final Logger logger = LogManager.getLogger();

    private WebDriver driver;

    public CreatePasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProvePage openProvePage(String password) {
        logger.info("Entering the password");
        passwordInput.sendKeys(password);
        logger.info("Entering the password done");
        logger.info("Entering the confirm password");
        passwordConfirmInput.sendKeys(password);
        logger.info("Entering the confirm password done");
        logger.info("Clicking next button");
        dalejButton.click();
        logger.info("Clicking next button done");
        return new ProvePage(driver);
    }
}
