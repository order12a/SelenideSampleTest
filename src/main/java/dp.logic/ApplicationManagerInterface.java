package dp.logic;

public interface ApplicationManagerInterface {
    void clearCookies();
    void directLogin(String user);
    void directLogin(String user, String backUrl);
    void directLogout(String baseURL);
    boolean isProd();
    NavigationHelperInterface getNavigationHelper();
    UserHelperInterface getUserHelper();
}
