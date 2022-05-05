package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SearchPage extends BasePage {

    private List<WebElement> checkboxBrands;
    private WebElement dropdownFilter;
    private WebElement cartButton;

    public SearchPage(WebDriver driver) {
        super(driver);
        init();
    }

    private void init() {
        dropdownFilter = findElementByXpath("//select", Duration.ofSeconds(60));
        checkboxBrands = findElementsByXpath("(//div/rz-scrollbar/div/div)[3]//a", Duration.ofSeconds(60));
        cartButton = findElementByXpath("//li[7]/rz-cart/button", Duration.ofSeconds(60));
    }

    public void selectDropDownFilter() {
        Select dropdown = new Select(dropdownFilter);
        dropdown.selectByVisibleText("От дорогих к дешевым");
    }

    public void clickOnBrand(String brand) {

        for (int i = 0; i < checkboxBrands.size(); i++) {
            String text = checkboxBrands.get(i).getText();

            if (text.startsWith(brand)) {
                checkboxBrands.get(i).click();
                break;
            }
        }

    }

    public void clickOnBuyButton() {
        List<WebElement> productsBuyButton = findElementsByXpath("//button[contains(@class,'buy-button')]", Duration.ofSeconds(60));
        productsBuyButton.get(0).click();
    }

    public void clickOnCartButton() {
        cartButton.click();
    }


}
