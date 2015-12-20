package logic.ready;

import dp.logic.ViewItemHelperInterface;
import model.Size;

public class ViewItemHelper extends DriverBasedHelper implements ViewItemHelperInterface{
    public ViewItemHelper(ApplicationManager manager) {
        super(manager.getWebdriver());
    }

    @Override
    public boolean isItemPageLoaded() {
        return pages.itemPage.ensurePageLoaded();
    }

    @Override
    public void addToCart() {

    }

    @Override
    public void downloadItem(Size size) {

    }

    @Override
    public void addToFavorites() {

    }

    @Override
    public boolean isPopupPageLoaded() {
        return false;
    }

    @Override
    public String getItemId() {
        return null;
    }
}
