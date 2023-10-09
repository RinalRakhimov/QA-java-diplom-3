package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private final WebDriver driver;
    public String ACCOUNT_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    private By profileLink = By.xpath(".//a[@href='/account/profile']");
    private By logoutButton = By.xpath(".//ul/li[3]/button[text()='Выход']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean accountPageProfileLinkIsVisible() {
        return driver.findElement(profileLink).isDisplayed();
    }
    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }
}
