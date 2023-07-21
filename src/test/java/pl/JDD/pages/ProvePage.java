package pl.JDD.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProvePage {

    @FindBy(id = "phoneNumberId")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//span[text()='Udowodnij, że jesteś człowiekiem']")
    public WebElement pageTitletext;

    @FindBy(xpath = "//span[text()='Dalej']")
    private WebElement dalejButton;

    private static final Logger logger = LogManager.getLogger();

    private WebDriver driver;

    public ProvePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void confirmPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(pageTitletext));
        logger.info("Confirm the page title");
        Assert.assertEquals(pageTitletext.getText(),"Udowodnij, że jesteś człowiekiem");
        logger.info("Confirm the page title: " + pageTitletext.getText());
    }
}
