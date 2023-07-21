package pl.JDD.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//div[@class='QS5gu sy4vM' and text()='Odrzuć wszystko']")
    private WebElement odrzucWszystkoButton;

    @FindBy(xpath = "//a[@class='gb_v' and text()='Gmail']")
    private WebElement gmailLink;

    @FindBy(xpath = "//span[text()='Utwórz konto']")
    private WebElement utworzKontoLink;

    @FindBy(xpath = "//span[text()='Do użytku osobistego']")
    private WebElement doUzytkuOsobistegoLink;

    private static final Logger logger = LogManager.getLogger();

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public GmailPage openGmailPage() {
        logger.info("Opening Gmail page");
        odrzucWszystkoButton.click();
        gmailLink.click();
        logger.info("Opening Gmail page done");
        return new GmailPage(driver);
    }

}
