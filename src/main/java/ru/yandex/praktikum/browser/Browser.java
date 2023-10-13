package ru.yandex.praktikum.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
    public static WebDriver getWebDriver(String browser){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        switch (browser){
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                return new ChromeDriver(options);
            case "Yandex":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
                return new ChromeDriver(options);
            default:
                throw new RuntimeException("Error: WebDriver not found");
        }
    }
}