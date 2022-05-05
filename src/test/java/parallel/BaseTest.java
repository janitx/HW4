package parallel;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.CartPage;
import page.HomePage;
import page.SearchPage;
import utils.PropertiesReader;
import utils.WebDriverThreadLocalSingleton;

public class BaseTest {

    @BeforeMethod
    public void testsSetUp() {
        String url = new PropertiesReader().getUrl();

        WebDriver driver = WebDriverThreadLocalSingleton.getInstance().getDriver();

        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverThreadLocalSingleton.getInstance().removeDriver();
    }


    public HomePage getHomePage() {
        return new HomePage(WebDriverThreadLocalSingleton.getInstance().getDriver());
    }

    public SearchPage getSearchPage() {
        return new SearchPage(WebDriverThreadLocalSingleton.getInstance().getDriver());
    }

    public CartPage getCartPage() {
        return new CartPage(WebDriverThreadLocalSingleton.getInstance().getDriver());
    }
}
