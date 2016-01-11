package logic.ready;

import dp.logic.NavigationHelperInterface;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.open;

public class NavigationHelper extends DriverBasedHelper implements NavigationHelperInterface{
    String urlHardCodded = "http://depositphotos.com";

    public NavigationHelper(ApplicationManager manager) {
        super(manager.getWebdriver());
    }

    @Override
    @Step
    public boolean openMainPage() {
        open(urlHardCodded);
        return pages.mainPageLoggedOut.ensurePageLoaded();
    }

    @Override
    @Step
    public boolean openSearchPage() {
        return false;
    }

    public boolean openStaticLoginPage() {
        return false;
    }

    public boolean openCart() {
        return false;
    }

    public boolean openProfilePage() {
        return false;
    }

    public boolean openCorporateAccounts() {
        return false;
    }

    @Override
    @Step
    public boolean openBuyerMenu() {
        return false;
    }

    @Override
    @Step
    public boolean openSellerMenu() {
        return false;
    }

    @Override
    @Step
    public boolean openFavoritesPage() {
        return false;
    }

    @Override
    @Step
    public boolean openOurPlansAndPrices() {
        return false;
    }

    @Override
    @Step
    public void openSignUpPage() {
        pages.anyPage.ensurePageLoaded();
        open("/signup.html");
    }

    @Override
    public void openRelativeUrl(String itemUrl) {

    }
}
