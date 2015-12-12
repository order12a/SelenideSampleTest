package dp.logic;

public interface UserHelperInterface {
    void login(String username, String password);
    boolean isLoggedIn(String username);
    void loginStatic(String username, String password);

    void registerNewUser();
}
