package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;


public class HomePage extends BasePage {

    private static final int SECONDS = 60;

    private WebElement searchBar;
    private WebElement findButton;


    public HomePage(WebDriver driver) {
        super(driver);
        init();
    }

    private void init() {
        searchBar = findElementByXpath("//input[@name='search']", Duration.ofSeconds(SECONDS));
        findButton = findElementByXpath("//button[contains(@class,'search-form__submit')]", Duration.ofSeconds(SECONDS));
    }

    public void inputSearchQuery(String searchQuery) {
        searchBar.clear();
        searchBar.sendKeys(searchQuery);
    }

    public void clickOnFindButton() {
        findButton.click();
    }
}

