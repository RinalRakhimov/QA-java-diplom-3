package ru.yandex.praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final WebDriver driver;
    public static final String REG_URL = "https://stellarburgers.nomoreparties.site/register";
    private By nameField = By.xpath(".//form/fieldset[1]/div/div/input");
    private By emailField = By.xpath(".//form/fieldset[2]/div/div/input");
    private By passwordField = By.xpath(".//form/fieldset[3]/div/div/input");
    private By regButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private By passwordError = By.xpath(".//form/fieldset[3]/div/p[text()='Некорректный пароль']");
    private By enterButton = By.xpath(".//div/p/a[text()='Войти']");

    private final String name;
    private final String email;
    private final String password;

    public RegistrationPage(WebDriver driver, String name, String email, String password) {
        this.driver = driver;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    @Step("Open registration page")
    public void open() {
        driver.get(REG_URL);
    }
    @Step("User data filling")
    public void userDataFilling(String name, String email, String password) {
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }
    @Step("Click registration button")
    public void clickRegistrationButton() {
        driver.findElement(regButton).click();
    }
    @Step("Click enter button")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
    @Step("Check notice of password error")
    public boolean passwordErrorIsVisible() {
        return driver.findElement(passwordError).isDisplayed();
    }
}
