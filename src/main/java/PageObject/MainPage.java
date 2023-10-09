package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;
    public String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
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
    public void open() {
        driver.get(MAIN_PAGE_URL);
    }
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
    public void clickPrivateOfficeButton() {
        driver.findElement(privateOfficeButton).click();
    }
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }
    public void clickLogoStellarBurgers() {
        driver.findElement(logoStellarBurgers).click();
    }
    public boolean constructorIsVisible() {
        return driver.findElement(constructorName).isDisplayed();
    }
    public boolean bunsHeaderIsVisible() {
        return driver.findElement(bunsHeader).isDisplayed();
    }
    public boolean saucesHeaderIsVisible() {
        return driver.findElement(saucesHeader).isDisplayed();
    }
    public boolean fillingsHeaderIsVisible() {
        return driver.findElement(fillingsHeader).isDisplayed();
    }
    public void clickBunsChapter() {
        driver.findElement(bunsChapter).click();
    }
    public void clickSaucesChapter() {
        driver.findElement(saucesChapter).click();
    }
    public void clickFillingsChapter() {
        driver.findElement(fillingsChapter).click();
    }
}
