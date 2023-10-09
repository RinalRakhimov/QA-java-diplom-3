package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private final WebDriver driver;
    public String FORGOT_PASSWORD_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    private By enterButton = By.xpath(".//div/p/a[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get(FORGOT_PASSWORD_URL);
    }
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
}