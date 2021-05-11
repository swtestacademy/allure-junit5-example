package pages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.LogUtil;

public class LoginPage extends BasePage {

    //*********Web Elements by using Page Factory*********
    @FindBy(how = How.ID, using = "email")
    public WebElement username;
    @FindBy(how = How.ID, using = "password")
    public WebElement password;
    @FindBy(how = How.ID, using = "loginButton")
    public WebElement loginButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"loginForm\"]/div[1]/div/div")
    public WebElement errorMessageUsername;
    @FindBy(how = How.XPATH, using = "//*[@id=\"loginForm\"]/div[2]/div/div")
    public WebElement errorMessagePassword;

    //*********Constructor*********
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //*********Page Methods*********
    public LoginPage andIloginToN11(String pusername, String ppassword) {
        writeText(username, pusername);
        writeText(password, ppassword);
        click(loginButton);
        return this;
    }

    public LoginPage ThenIVerifyLoginUserNameErrorMessage(String expectedText) {
        assertEquals(readText(errorMessageUsername), expectedText);
        return this;
    }

    public LoginPage thenIVerifyPasswordErrorMessage(String expectedText) {
        assertEquals(readText(errorMessagePassword), expectedText);
        return this;
    }

    public LoginPage thenIVerifyLogEntryFailMessage() {
        assertTrue(LogUtil.isLoginErrorLog(driver));
        return this;
    }
}
