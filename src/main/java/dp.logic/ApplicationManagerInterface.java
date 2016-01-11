package dp.logic;

import model.User;

public interface ApplicationManagerInterface {
    void clearCookies();
    void directLogin(User user, String baseUrl);
    void directLogin(String baseURL, User user, String backUrl);
    void directLogout(String baseURL);
    boolean isProd();
    String getCurrentUrl();
    NavigationHelperInterface getNavigationHelper();
    UserHelperInterface getUserHelper();
    SearchHelperInterface getSearchHelper();
    CartHelperInterface getCartHelper();
    ViewItemHelperInterface getViewItemHelper();
    String getBaseUrl();
}
