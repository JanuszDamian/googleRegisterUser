package pl.JDD.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasicInfoPage {

    @FindBy(id = "day")
    private WebElement dayInput;

    @FindBy(id = "month")
    public WebElement monthSelect;

    @FindBy(id = "year")
    private WebElement yearInput;

    @FindBy(id = "gender")
    private WebElement genderSelect;

    @FindBy(xpath = "//span[text()='Dalej']")
    private WebElement dalejButton;

    private static final Logger logger = LogManager.getLogger();

    private WebDriver driver;

    public BasicInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoginMethod openLoginMethod(String day, String year) {
        logger.info("Entering the day number");
        dayInput.sendKeys(day);
        logger.info("Entering the day number done");

        logger.info("Selecting the month");
        Select months = new Select(monthSelect);
        months.selectByIndex(1);
        logger.info("Selecting the month done");

        logger.info("Entering the year number");
        yearInput.sendKeys(year);
        logger.info("Entering the year number done");

        logger.info("Gender selecting");
        Select genders = new Select(genderSelect);
        genders.selectByVisibleText("Mężczyzna");
        logger.info("Gender selecting done");

        logger.info("Clicking next button");
        dalejButton.click();
        logger.info("Clicking next button done");
        return new LoginMethod(driver);
    }


}
