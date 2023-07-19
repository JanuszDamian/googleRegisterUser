package pl.JDD.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailPage {

    @FindBy(xpath = "//span[text()='Utwórz konto']")
    private WebElement utworzKontoLink;

    @FindBy(xpath = "//span[text()='Do użytku osobistego']")
    private WebElement doUzytkuOsobistegoLink;

    private WebDriver driver;

    public GmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public NamePage openNamePage() {
        utworzKontoLink.click();
        doUzytkuOsobistegoLink.click();
        return new NamePage(driver);
    }
}
