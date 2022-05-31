import model.FilterProductModel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.PropertiesReader;
import utils.XmlToModelReader;


@Listeners(CheckSumInCartListener.class)
public class CheckSumInCartTest extends BaseTest {

    @DataProvider(name = "filters-file-xml")
    public Object[][] getData() {

        FilterProductModel model = XmlToModelReader.read(new PropertiesReader().getPathToFiltersFileXml());

        Object[][] array = model.getCollection().stream()
                .map(productModel -> new Object[]{
                        productModel.getId(), productModel.getProduct(), productModel.getBrand(), productModel.getPrice()
                }).toArray(Object[][]::new);

        return array;
    }

    @Test(dataProvider = "filters-file-xml")
    public void checkIfSumInCartIsLess(int id, String product, String brand, int maxPrice) {

        var homepage = getHomePage();// inputSearchQuery(product);
        homepage.inputSearchQuery(product);
        homepage.clickOnFindButton();


        var searchPage = getSearchPage();

        searchPage.selectDropDownFilter();
        searchPage.clickOnBrand(brand);
        searchPage.clickOnBuyButton();
        searchPage.clickOnCartButton();

        int cartPrice = Integer.parseInt(getCartPage().getTextOfPriceProductInCart());

        Assert.assertTrue(cartPrice < maxPrice, String.format(" Id%s cartPrice(%s) < maxPrice(%s)", id, cartPrice, maxPrice));
    }
}
