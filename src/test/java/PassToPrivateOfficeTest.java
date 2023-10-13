import ru.yandex.praktikum.api.User;
import ru.yandex.praktikum.api.UserSteps;
import ru.yandex.praktikum.browser.Browser;
import ru.yandex.praktikum.pageobject.AccountPage;
import ru.yandex.praktikum.pageobject.LoginPage;
import ru.yandex.praktikum.pageobject.MainPage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class PassToPrivateOfficeTest {
    private WebDriver driver;
    private String name;
    private String email;
    private String password;
    private String accessToken;
    private String browser = "Yandex";

    @Before
    public void before() {
        driver = Browser.getWebDriver(browser);
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
    }
    @Test
    @DisplayName("Pass to private office throw click on private office button after authorization")
    public void successPassToPrivateOffice() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        email = RandomStringUtils.randomAlphanumeric(6, 10) + "@yandex.ru";
        password = RandomStringUtils.randomAlphanumeric(10, 20);
        name = RandomStringUtils.randomAlphanumeric(4, 20);

        UserSteps.sendPostRequestUserCreation(new User(email, password, name));

        MainPage objMainPage = new MainPage(driver);

        LoginPage objLoginPage = new LoginPage(driver, email, password);

        objMainPage.open();
        objMainPage.clickEnterButton();
        objLoginPage.authorization();
        objLoginPage.clickEnterButton();
        objMainPage.clickPrivateOfficeButton();

        AccountPage objAccountPage = new AccountPage(driver);

        Response responseLoginOfExistUser = UserSteps.sendPostRequestUserLogin(new User(email, password, null));
        accessToken = responseLoginOfExistUser.then().extract().path("accessToken");

        assertTrue(objAccountPage.accountPageProfileLinkIsVisible());
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
