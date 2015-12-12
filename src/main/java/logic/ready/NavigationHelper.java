package logic.ready;

import dp.logic.NavigationHelperInterface;

import static com.codeborne.selenide.Selenide.open;

public class NavigationHelper extends DriverBasedHelper implements NavigationHelperInterface{
    String urlHardCodded = "http://depositphotos.com";

    public NavigationHelper(ApplicationManager manager) {
        super(manager.getWebdriver());
    }

    public boolean openMainPage() {
        open(urlHardCodded);
        return pages.mainPageLoggedOut.ensurePageLoaded();
    }

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

    public boolean openBuyerMenu() {
        return false;
    }

    public boolean openSellerMenu() {
        return false;
    }

    public boolean openFavoritesPage() {
        return false;
    }

    public boolean openOurPlansAndPrices() {
        return false;
    }

    public void openSignUpPage() {
        pages.anyPage.ensurePageLoaded();
        open("/signup.html");
    }
}
