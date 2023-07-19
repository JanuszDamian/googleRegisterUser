package pl.JDD.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.JDD.pages.HomePage;

public class RegisterUserTest extends BaseTest {

    @Test
    public void registerUserTest() {

        new HomePage(driver)
                .openGmailPage()
                .openNamePage()
                .openBasicInfoPage("aa", "bb")
                .openLoginMethod("14", "1988")
                .openCreatePasswordPage()
                .openProvePage("Abcd102938$")
                .confirmPage();
    }
}
