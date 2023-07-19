package pl.JDD.pages;

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

    private WebDriver driver;

    public CreatePasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProvePage openProvePage(String password) {
        passwordInput.sendKeys(password);
        passwordConfirmInput.sendKeys(password);
        dalejButton.click();
        return new ProvePage(driver);
    }
}
