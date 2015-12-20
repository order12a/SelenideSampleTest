package dp.logic;

import model.Size;

public interface ViewItemHelperInterface {
    boolean isItemPageLoaded();
    void addToCart();
    void downloadItem(Size size);
    void addToFavorites();
    boolean isPopupPageLoaded();
    String getItemId();
}
