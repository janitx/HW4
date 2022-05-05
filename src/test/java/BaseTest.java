import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.CartPage;
import page.HomePage;
import page.SearchPage;
import utils.PropertiesReader;
import utils.WebDriverSingleton;


public class BaseTest {

    @BeforeMethod
    public void testsSetUp() {
        String url = new PropertiesReader().getUrl();

        WebDriverSingleton.getInstance().manage().window().maximize();
        WebDriverSingleton.getInstance().get(url);
    }

    @AfterMethod
    public void tearDown() {

        WebDriverSingleton.closeBrowser();
    }

    public HomePage getHomePage() {
        return new HomePage(WebDriverSingleton.getInstance());
    }

    public SearchPage getSearchPage() {
        return new SearchPage(WebDriverSingleton.getInstance());
    }

    public CartPage getCartPage() {
        return new CartPage(WebDriverSingleton.getInstance());
    }
}



