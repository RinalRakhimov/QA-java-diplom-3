package ru.yandex.praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;
    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    private By enterButton = By.xpath(".//div/main/section[2]/div/button[text()='Войти в аккаунт']");

    private By privateOfficeButton = By.xpath(".//div/header/nav/a/p[text()='Личный Кабинет']");

    private By constructorButton = By.xpath(".//header/nav/ul/li[1]/a/p[text()='Конструктор']");

    private By constructorName = By.xpath(".//section[1]/h1[text()='Соберите бургер']");

    private By logoStellarBurgers = By.xpath(".//header/nav/div/a");
    private By bunsChapter = By.xpath(".//span[text()='Булки']");
    private By saucesChapter = By.xpath(".//span[text()='Соусы']");
    private By fillingsChapter = By.xpath(".//span[text()='Начинки']");
    private By bunsHeader = By.xpath(".//h2[text()='Булки']");
    private By saucesHeader = By.xpath(".//h2[text()='Соусы']");
    private By fillingsHeader = By.xpath(".//h2[text()='Начинки']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Open main page")
    public void open() {
        driver.get(MAIN_PAGE_URL);
    }
    @Step("Click enter button")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
    @Step("Click private office button")
    public void clickPrivateOfficeButton() {
        driver.findElement(privateOfficeButton).click();
    }
    @Step("Click constructor button")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }
    @Step("Click logo StellarBurgers")
    public void clickLogoStellarBurgers() {
        driver.findElement(logoStellarBurgers).click();
    }
    @Step("Check constructor visibility")
    public boolean constructorIsVisible() {
        return driver.findElement(constructorName).isDisplayed();
    }
    @Step("Check buns header visibility")
    public boolean bunsHeaderIsVisible() {
        return driver.findElement(bunsHeader).isDisplayed();
    }
    @Step("Check sauces header visibility")
    public boolean saucesHeaderIsVisible() {
        return driver.findElement(saucesHeader).isDisplayed();
    }
    @Step("Check fillings header visibility")
    public boolean fillingsHeaderIsVisible() {
        return driver.findElement(fillingsHeader).isDisplayed();
    }
    @Step("Click buns chapter")
    public void clickBunsChapter() {
        driver.findElement(bunsChapter).click();
    }
    @Step("Click sauces chapter")
    public void clickSaucesChapter() {
        driver.findElement(saucesChapter).click();
    }
    @Step("Click fillings chapter")
    public void clickFillingsChapter() {
        driver.findElement(fillingsChapter).click();
    }
}
