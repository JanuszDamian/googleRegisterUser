package pl.JDD.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NamePage {

    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(xpath = "//span[text()='Dalej']")
    private WebElement dalejButton;

    private static final Logger logger = LogManager.getLogger();

    private WebDriver driver;

    public NamePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public BasicInfoPage openBasicInfoPage(String firstName, String lastName) {
        logger.info("Entering the name");
        firstNameInput.sendKeys(firstName);
        logger.info("Entering the name done");
        logger.info(("Entering the last Name"));
        lastNameInput.sendKeys(lastName);
        logger.info("Entering the last name done");
        logger.info("Clicking next button");
        dalejButton.click();
        logger.info("Clicking next button done");
        return new BasicInfoPage(driver);
    }
}
