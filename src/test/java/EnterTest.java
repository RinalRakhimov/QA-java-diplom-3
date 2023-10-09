import PageObject.ForgotPasswordPage;
import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class EnterTest {
    private WebDriver driver;

    @Before
    public void before() {
        ChromeOptions chromeOptions = new ChromeOptions();
        //System.setProperty("webdriver.chrome.driver", "yandexdriver.exe");
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();
    }

    @Test
    @DisplayName("Enter throw enter button on main page")
    public void successEnterThrowMainPage() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver, null, null);

        objMainPage.open();
        objMainPage.clickEnterButton();

        assertTrue(objLoginPage.loginPageIsVisible());
    }

    @Test
    @DisplayName("Enter throw private office on mane page")
    public void successEnterThrowPrivateOffice() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver, null, null);

        objMainPage.open();
        objMainPage.clickPrivateOfficeButton();

        assertTrue(objLoginPage.loginPageIsVisible());
    }

    @Test
    @DisplayName("Enter throw enter button on registration page")
    public void successEnterThrowRegistrationPage() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        RegistrationPage objRegPage = new RegistrationPage(driver, null, null, null);
        LoginPage objLoginPage = new LoginPage(driver, null, null);

        objRegPage.open();
        objRegPage.clickEnterButton();

        assertTrue(objLoginPage.loginPageIsVisible());
    }

    @Test
    @DisplayName("Enter throw enter button on forgot password page")
    public void successEnterThrowForgotPasswordPage() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ForgotPasswordPage objForgotPasswordPage = new ForgotPasswordPage(driver);
        LoginPage objLoginPage = new LoginPage(driver, null, null);

        objForgotPasswordPage.open();
        objForgotPasswordPage.clickEnterButton();

        assertTrue(objLoginPage.loginPageIsVisible());
    }

    @After
    public void after() {
        driver.quit();
    }
}
