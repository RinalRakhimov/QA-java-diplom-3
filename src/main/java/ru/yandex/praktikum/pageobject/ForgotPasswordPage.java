package ru.yandex.praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private final WebDriver driver;
    public static final String FORGOT_PASSWORD_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    private By enterButton = By.xpath(".//div/p/a[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Open forgot password page")
    public void open() {
        driver.get(FORGOT_PASSWORD_URL);
    }
    @Step("Click enter button")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
}