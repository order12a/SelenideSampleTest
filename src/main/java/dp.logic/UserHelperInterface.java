package dp.logic;

import model.Size;

public interface UserHelperInterface {
    void login(String username, String password);
    boolean isLoggedIn(String username);
    void loginStatic(String username, String password);
    void registerNewUser();

    void downloadItem(Size m);

    void isUserRedirectedTo(String expectedUrl);

    boolean isCartIndexIncreased();
}
