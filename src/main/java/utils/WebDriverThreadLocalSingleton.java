package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public final class WebDriverThreadLocalSingleton {

    private static WebDriverThreadLocalSingleton instance = new WebDriverThreadLocalSingleton();

    ThreadLocal<WebDriver> drivers = new ThreadLocal<>() {
        @Override
        protected WebDriver initialValue() {
            chromedriver().setup();
            return new ChromeDriver();
        }
    };

    private WebDriverThreadLocalSingleton() {

    }

    public static WebDriverThreadLocalSingleton getInstance() {
        return instance;
    }

    public WebDriver getDriver() {
        return drivers.get();
    }

    public void removeDriver() {
        drivers.get().quit();
        drivers.remove();
    }
}

