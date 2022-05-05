package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class CartPage extends BasePage {

    private WebElement priceProductInCart;

    public CartPage(WebDriver driver) {
        super(driver);
        init();
    }

    private void init() {
        priceProductInCart = findElementByXpath("(//div[@class='cart-receipt__sum-price']/span)[1]", Duration.ofSeconds(60));
    }

    public String getTextOfPriceProductInCart() {
        return priceProductInCart.getText();
    }
}