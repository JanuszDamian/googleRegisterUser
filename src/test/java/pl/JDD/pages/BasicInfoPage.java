package pl.JDD.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasicInfoPage {

    private WebDriver driver;
    public BasicInfoPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
}
