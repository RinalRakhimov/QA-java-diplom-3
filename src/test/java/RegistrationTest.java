import API.User;
import API.UserSteps;
import PageObject.LoginPage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.restassured.RestAssured;
import PageObject.RegistrationPage;

import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.RandomStringUtils;

public class RegistrationTest {
    private String name;
    private String email;
    private String password;
    private String accessToken;
    private WebDriver driver;

    @Before
    public void before() {
        ChromeOptions chromeOptions = new ChromeOptions();
        //System.setProperty("webdriver.chrome.driver", "yandexdriver.exe");
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();

        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
    }

    @Test
    @DisplayName("New user success registration")
    public void successRegistration() {
        email = RandomStringUtils.randomAlphanumeric(6, 10) + "@yandex.ru";
        password = RandomStringUtils.randomAlphanumeric(10, 20);
        name = RandomStringUtils.randomAlphanumeric(4, 20);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        RegistrationPage objRegistrationPage = new RegistrationPage(driver,name, email, password);
        LoginPage objLoginPage = new LoginPage(driver, email, password);

        // переход на страницу тестового приложения
        objRegistrationPage.open();
        objRegistrationPage.userDataFilling(name, email, password);
        objRegistrationPage.clickRegistrationButton();

        assertTrue("Не удалось зарегистрировать нового пользователя", objLoginPage.loginPageIsVisible());

        Response responseLoginOfExistUser = UserSteps.sendPostRequestUserLogin(new User(email, password, null));
        accessToken = responseLoginOfExistUser.then().extract().path("accessToken");
    }

    @Test
    @DisplayName("New user not success registration")
    public void notSuccessRegistration() {
        email = RandomStringUtils.randomAlphanumeric(6, 10) + "@yandex.ru";
        password = RandomStringUtils.randomAlphanumeric(1, 5);
        name = RandomStringUtils.randomAlphanumeric(4, 20);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        RegistrationPage objRegistrationPage = new RegistrationPage(driver,name, email, password);

        // переход на страницу тестового приложения
        objRegistrationPage.open();
        objRegistrationPage.userDataFilling(name, email, password);
        objRegistrationPage.clickRegistrationButton();

        assertTrue(objRegistrationPage.passwordErrorIsVisible());
    }

    @After
    public void after() {
        if (accessToken != null) {
            UserSteps.deleteUser(accessToken);
            driver.quit();
        }
        driver.quit();
    }
}
