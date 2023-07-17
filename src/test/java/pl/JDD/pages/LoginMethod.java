package pl.JDD.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginMethod {

    @FindBy(xpath = "//div[text()='Utwórz własny adres Gmail']")
    private WebElement radioOwnAddressEmail;

    @FindBy(name = "Username")
    private WebElement userNameInput;

    @FindBy(xpath = "//span[text()='Dalej']")
    private WebElement dalejButton;

    private WebDriver driver;
    public LoginMethod(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CreatePasswordPage openCreatePasswordPage(String login) {
        radioOwnAddressEmail.click();
        userNameInput.sendKeys(login);
        dalejButton.click();
        return new CreatePasswordPage(driver);
    }
}
