package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class BasePage {

    protected static WebDriver driver;

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void closeWindow() {
        driver.close();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    //Wait
    private WebDriverWait getWaiter(long timeOutInSeconds) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));

        webDriverWait.ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class);

        return webDriverWait;
    }

    private By waitForElementVisible(By findStrategy, long timeOutInSeconds) {
        getWaiter(timeOutInSeconds).until(visibilityOfElementLocated(findStrategy));
        return findStrategy;
    }

    public WebElement findElementByXpath(String xpath, Duration duration) {
        return driver.findElement(waitForElementVisible(By.xpath(xpath), duration.getSeconds()));
    }

    public List<WebElement> findElementsByXpath(String xpath, Duration duration) {
        return driver.findElements(waitForElementVisible(By.xpath(xpath), duration.getSeconds()));
    }

}
