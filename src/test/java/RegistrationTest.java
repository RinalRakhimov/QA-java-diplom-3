import ru.yandex.praktikum.api.User;
import ru.yandex.praktikum.api.UserSteps;
import ru.yandex.praktikum.browser.Browser;
import ru.yandex.praktikum.pageobject.LoginPage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import io.restassured.RestAssured;
import ru.yandex.praktikum.pageobject.RegistrationPage;

import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.RandomStringUtils;

public class RegistrationTest {
    private String name;
    private String email;
    private String password;
    private String accessToken;
    private WebDriver driver;
    private String browser = "Chrome";

    @Before
    public void before() {
        driver = Browser.getWebDriver(browser);
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

        Response responseLoginOfExistUser = UserSteps.sendPostRequestUserLogin(new User(email, password, null));
        accessToken = responseLoginOfExistUser.then().extract().path("accessToken");

        assertTrue("Не удалось зарегистрировать нового пользователя", objLoginPage.loginPageIsVisible());
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
