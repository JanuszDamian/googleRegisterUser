package pl.JDD.tests;

import org.testng.annotations.Test;
import pl.JDD.pages.HomePage;

public class RegisterUserTest extends BaseTest {

    @Test
    public void registerUserTest() {
        int randomNumber = (int) (Math.random() * 1000);
        new HomePage(driver)
                .openGmailPage()
                .openNamePage()
                .openBasicInfoPage("aa","bb")
                .openLoginMethod("14","1988")
                .openCreatePasswordPage("dsfgsh"+randomNumber);
    }
}
