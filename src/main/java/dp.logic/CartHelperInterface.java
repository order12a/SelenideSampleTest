package dp.logic;


import model.Size;

public interface CartHelperInterface {
    boolean isCartPageLoaded();
    void clearCart();
    void downloadItemFromCart(Size size);
    String getItemsQuantity();
    boolean hasCartItem(String itemId);
}
