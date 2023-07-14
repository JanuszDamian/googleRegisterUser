package pl.JDD.tests;

import org.testng.annotations.Test;
import pl.JDD.pages.HomePage;

public class RegisterUserTest extends BaseTest {

    @Test
    public void registerUserTest() {
        new HomePage(driver)
                .openGmailPage()
                .openNamePage()
                .openBasicInfoPage("Aa","Bb");
    }
}
