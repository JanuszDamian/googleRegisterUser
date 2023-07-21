package pl.JDD.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailPage {

    @FindBy(xpath = "//span[text()='Utwórz konto']")
    private WebElement utworzKontoLink;

    @FindBy(xpath = "//span[text()='Do użytku osobistego']")
    private WebElement doUzytkuOsobistegoLink;

    private static final Logger logger = LogManager.getLogger();

    private WebDriver driver;

    public GmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public NamePage openNamePage() {
        logger.info("Opening Create account link");
        utworzKontoLink.click();
        logger.info("Opening Create account link done");
        logger.info("");
        logger.info("Purpose of the account");
        doUzytkuOsobistegoLink.click();
        logger.info("Purpose of the account done");
        return new NamePage(driver);
    }
}
