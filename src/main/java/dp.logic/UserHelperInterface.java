package dp.logic;

public interface UserHelperInterface {
    void login(String username, String password);
    boolean isLoggedIn(String username);
}
