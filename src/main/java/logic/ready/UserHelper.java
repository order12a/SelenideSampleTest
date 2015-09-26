package logic.ready;

import dp.logic.UserHelperInterface;
import ru.yandex.qatools.allure.annotations.Step;

public class UserHelper extends DriverBasedHelper implements UserHelperInterface {
    public UserHelper(ApplicationManager manager) {
        super(manager.getWebdriver());
    }

    @Step("Login user {0} with password {1}")
    public void login(String username, String password) {
        pages.mainPageLoggedOut.clickLoginButton();
        pages.loginTip.login(username, password);
    }

    @Step("Check user with name{0} is successfully logged in")
    public boolean isLoggedIn(String username) {
        return pages.mainPageLoggedIn.isLoggedIn(username);
    }

    @Override
    public void loginStatic(String username, String password) {
        pages.loginPageStatic.ensurePageLoaded();
        pages.loginPageStatic.login(username, password);
    }
}
