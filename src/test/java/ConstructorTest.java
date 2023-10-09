import PageObject.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class ConstructorTest {

    private WebDriver driver;

    @Before
    public void before() {
        ChromeOptions chromeOptions = new ChromeOptions();
        //System.setProperty("webdriver.chrome.driver", "yandexdriver.exe");
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();
    }

    @Test
    @DisplayName("Pass to sauces chapter")
    @Description("Pass to sauces chapter")
    public void successPassToSaucesChapter() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.open();
        objMainPage.clickSaucesChapter();
        assertTrue(objMainPage.saucesHeaderIsVisible());
    }

    @Test
    @DisplayName("Pass to fillings chapter")
    public void successPassToFillingsChapter() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.open();
        objMainPage.clickFillingsChapter();
        assertTrue(objMainPage.fillingsHeaderIsVisible());
    }

    @Test
    @DisplayName("Pass to buns chapter")
    public void successPassToBunsChapter() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.open();
        objMainPage.clickFillingsChapter();
        assertTrue(objMainPage.fillingsHeaderIsVisible());
        objMainPage.clickBunsChapter();
        assertTrue(objMainPage.bunsHeaderIsVisible());
    }

    @After
    public void after() {
       driver.quit();
    }
}
