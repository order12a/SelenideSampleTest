import bases.TestDataClass;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Parameter;

@RunWith(DataProviderRunner.class)
public class Cart extends TestDataClass {

    @Before
    public void before(){
        app.clearCookies();
    }

    @Test
    @Ignore
    @Description("Add items to cart from from search result")
    public void addToCardFromSearchResult(){
        int[] items = new int[3];
        app.getSearchHelper().searchFromMainPage("sun");
        app.getSearchHelper().addItemsFromSearchToCart(items);
        Assert.assertTrue("Cart index is not increased.",  app.getUserHelper().isCartIndexIncreased());
        app.getNavigationHelper().openCart();
        app.getCartHelper().isCartPageLoaded();
        Assert.assertTrue("No images present at cart.", app.getCartHelper().getItemsQuantity().equals(items.length));
        app.getCartHelper().clearCart();
        Assert.assertTrue("There are images left in the cart.", app.getCartHelper().getItemsQuantity().equals("0"));
    }

    @Test
    @Description("Add item to cart from item page")
    @UseDataProvider(value = "cart_and_item", location = TestDataClass.class)
    public void addToCartFromItemPage(@Parameter("item link") String itemUrl, @Parameter("Item ID") String itemId){
        app.getNavigationHelper().openRelativeUrl(itemUrl);
        app.getViewItemHelper().addToCart();
        Assert.assertTrue("Cart index is not increased.",  app.getUserHelper().isCartIndexIncreased());
        app.getNavigationHelper().openCart();
        Assert.assertTrue("Cart page is not displayed.", app.getCartHelper().isCartPageLoaded());
        Assert.assertTrue("There are no images left in the cart.", app.getCartHelper().getItemsQuantity().equals("1"));
        Assert.assertTrue("Expected item was not found in cart.", app.getCartHelper().hasCartItem(itemId));
    }

    @Test
    @Ignore
    @Description("Add item to cart from popup item view after search")
    public void addToCartAndRedirectWithoutPlanFromPopup(){
        app.getSearchHelper().searchFromMainPage("sun");
        app.getSearchHelper().openItemFromSearchResult(1);
        Assert.assertTrue("Item in popup was not opened", app.getViewItemHelper().isPopupPageLoaded());
        app.getViewItemHelper().addToCart();
        String itemId = app.getViewItemHelper().getItemId();
        Assert.assertTrue("Cart index is not increased.",  app.getUserHelper().isCartIndexIncreased());
        app.getNavigationHelper().openCart();
        Assert.assertTrue("Cart page is not displayed.", app.getCartHelper().isCartPageLoaded());
        Assert.assertTrue("There are images left in the cart.", app.getCartHelper().getItemsQuantity().equals("1"));
        Assert.assertTrue("Expected item was not found in cart.", app.getCartHelper().hasCartItem(itemId));
    }

}
