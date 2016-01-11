package dp.logic;

public interface NavigationHelperInterface {
    boolean openMainPage();
    boolean openSearchPage();
    boolean openStaticLoginPage();
    boolean openCart();
    boolean openProfilePage();
    boolean openCorporateAccounts();
    boolean openBuyerMenu();
    boolean openSellerMenu();
    boolean openFavoritesPage();
    boolean openOurPlansAndPrices();

    void openSignUpPage();

    void openRelativeUrl(String itemUrl);
}
