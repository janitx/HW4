package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public final class WebDriverSingleton {

    private static WebDriver instance;

    private WebDriverSingleton() {
    }

    public static WebDriver getInstance() {

        if (instance == null) {
            chromedriver().setup();
            instance = new ChromeDriver();
        }

        return instance;
    }

    public static void closeBrowser() {
        instance.quit();
        instance = null;
    }


}