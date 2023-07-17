package pl.JDD.pages;

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

    private WebDriver driver;
    public BasicInfoPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public LoginMethod openLoginMethod(String day, String year) {
        dayInput.sendKeys(day);

        Select months = new Select(monthSelect);
        months.selectByIndex(1);

        yearInput.sendKeys(year);

        Select genders = new Select(genderSelect);
        genders.selectByVisibleText("Mężczyzna");

        dalejButton.click();
        return new LoginMethod(driver);
    }


}
