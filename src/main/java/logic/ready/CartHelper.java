package logic.ready;

import dp.logic.CartHelperInterface;
import model.Size;
import ru.yandex.qatools.allure.annotations.Step;

public class CartHelper extends DriverBasedHelper implements CartHelperInterface{
    public CartHelper(ApplicationManager manager) {
        super(manager.getWebdriver());
    }

    @Override
    @Step
    public boolean isCartPageLoaded() {
        return false;
    }

    @Override
    @Step
    public void clearCart() {
        pages.cartPage.ensurePageLoaded();
        pages.cartPage.clearCart();
    }

    @Override
    @Step
    public void downloadItemFromCart(Size size) {
        //TODO implement
    }

    @Override
    @Step("Get amount of items in cart")
    public String getItemsQuantity() {
        return pages.cartPage.getCounterOfItems();
    }

    @Override
    @Step("Verify that expected item with id {0} present in cart")
    public boolean hasCartItem(String itemId) {
        String itemInCart = pages.cartPage.getItemId();
        return itemInCart.equalsIgnoreCase(itemId);
    }
}
