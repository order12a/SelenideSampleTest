package logic.ready;

import dp.logic.NavigationHelperInterface;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.open;

public class NavigationHelper extends DriverBasedHelper implements NavigationHelperInterface{
    String baseUrl;

    public NavigationHelper(ApplicationManager manager) {
        super(manager.getWebdriver());
    }

    @Override
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    @Step
    public boolean openMainPage() {
        open(baseUrl);
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
        open(baseUrl + "/cart.html");
        return pages.cartPage.ensurePageLoaded();
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
        open(baseUrl + "/subscribe.html");
        return pages.anyPage.ensurePageLoaded();
    }

    @Override
    @Step
    public boolean openSignUpPage() {
        pages.anyPage.ensurePageLoaded();
        open("/signup.html");
        return false;
    }

    @Override
    @Step
    public void openRelativeUrl(String url) {
        open(baseUrl + url);
        pages.anyPage.ensurePageLoaded();
    }
}
