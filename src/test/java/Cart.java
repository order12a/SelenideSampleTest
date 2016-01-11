import bases.TestDataClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class Cart extends TestDataClass {

    @Before
    public void before(){
        app.clearCookies();
    }

    @Test
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
    public void addToCartFromItemPage(){
        String itemUrl = "";
        String itemId = "";
        app.getNavigationHelper().openRelativeUrl(itemUrl);
        app.getViewItemHelper().addToCart();
        Assert.assertTrue("Cart index is not increased.",  app.getUserHelper().isCartIndexIncreased());
        app.getNavigationHelper().openCart();
        Assert.assertTrue("Cart page is not displayed.", app.getCartHelper().isCartPageLoaded());
        Assert.assertTrue("There are images left in the cart.", app.getCartHelper().getItemsQuantity().equals("1"));
        Assert.assertTrue("Expected item was not found in cart.", app.getCartHelper().hasCartItem(itemId));
    }

    @Test
    @Description("Add item to cart from popup item view after search")
    public void addToCartAndRedirectWithoutPlans(){
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
