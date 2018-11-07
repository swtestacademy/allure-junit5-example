import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Login Tests Epic")
@Feature("Invalid Login Features")
public class LoginTest extends BaseTest {

    @Test
    @Story("User tries to login the system with invalid username and invalid password.")
    @Description("Invalid Login Test with Invalid Username and Invalid Password.")
    public void invalidLoginTest_InvalidUserNameInvalidPassword () {
        page.getPage(HomePage.class)
                .GivenIAmAtHomePage()
                .WhenIGoToLoginPage()
                .AndIloginToN11("onur@swtestacademy.com", "11223344")
                .ThenIVerifyPasswordErrorMessage(("E-posta adresiniz veya şifreniz hatalı"));
    }

    @Test
    @Story("User tries to login the system with empty username and invalid password.")
    @Description("Invalid Login Test with Empty Username and Invalid Password.")
    public void invalidLoginTest_EmptyUserEmptyPassword () {
        page.getPage(HomePage.class)
                .GivenIAmAtHomePage()
                .WhenIGoToLoginPage()
                .AndIloginToN11("","")
                .ThenIVerifyLoginUserNameErrorMessage("Lütfen e-posta adresinizi girin.")
                .ThenIVerifyPasswordErrorMessage("Bu alanın doldurulması zorunludur.");
    }

    @Test
    @Story("This is a Fail Story.")
    @Description("This is a Fail Story Description.")
    public void failTest () {
        assertTrue(false);
    }

}
