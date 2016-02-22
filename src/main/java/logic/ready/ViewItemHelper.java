package logic.ready;

import dp.logic.ViewItemHelperInterface;
import model.Size;
import ru.yandex.qatools.allure.annotations.Step;

public class ViewItemHelper extends DriverBasedHelper implements ViewItemHelperInterface{
    public ViewItemHelper(ApplicationManager manager) {
        super(manager.getWebdriver());
    }

    @Override
    public boolean isItemPageLoaded() {
        return pages.itemPage.ensurePageLoaded();
    }

    @Override
    @Step
    public void addToCart() {
        pages.itemPage.ensurePageLoaded();
        pages.itemPage.addToCart();
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
