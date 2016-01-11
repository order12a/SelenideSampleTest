package logic.ready;

import com.codeborne.selenide.WebDriverRunner;
import dp.logic.*;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.open;

public class ApplicationManager extends DriverBasedHelper implements ApplicationManagerInterface{

//    protected static String baseUrl;
    private String baseUrl = "http://depositphotos.com";
    private UserHelperInterface userHelperInterface;
    private NavigationHelperInterface navigationHelperInterface;
    private SearchHelperInterface searchHelperInterface;
    private CartHelperInterface cartHelperInterface;
    private ViewItemHelperInterface viewItemHelperInterface;
//    protected WebDriver driver;

    public ApplicationManager() {
//      baseUrl = PropertyLoader.loadProperty("site.url");
        initiateAllHelpers();
    }

    public void initiateAllHelpers(){
        userHelperInterface = new UserHelper(this);
        navigationHelperInterface = new NavigationHelper(this);
        searchHelperInterface = new SearchHelper(this);
        cartHelperInterface = new CartHelper(this);
        viewItemHelperInterface = new ViewItemHelper(this);
    }


    public void clearCookies() {
        if(WebDriverRunner.getWebDriver() != null && WebDriverRunner.getWebDriver().getWindowHandles().size() > 0){
            try {
                WebDriverRunner.clearBrowserCache();
            }catch (WebDriverException e){
                WebDriverRunner.getWebDriver().getCurrentUrl();
                e.printStackTrace();
            }
        }

        open(baseUrl);
    }

    @Step("Direct login of current user {0}.")
    public void directLogin(User user, String baseUrl) {
        directLogin(baseUrl, user, new String());
    }

    @Step("Direct login of current user. With target url {2}")
    public void directLogin(String baseURL, User user, String backUrl) {
        if(backUrl.isEmpty()){
            open(baseURL + "/login.html?username=" + user.getUsername() + "&password=" + user.getPassword());
        }else {
            open(baseURL + "/login.html?username=" + user.getUsername() + "&password=" + user.getPassword() + "&backURL[page]=" + backUrl);
        }
        pages.anyPage.ensurePageLoaded();
        pages.anyPage.waitForAjaxResponse(15);
    }

    @Step("Direct logout from user account: {0}")
    public void directLogout(String baseURL) {
        open(baseURL + "/login/logout.html?backURL=login.html");
    }

    public boolean isProd() {
        //TODO implement
        return false;
    }

    @Override
    public NavigationHelperInterface getNavigationHelper() {
        return navigationHelperInterface;
    }

    @Override
    public UserHelperInterface getUserHelper() {
        return userHelperInterface;
    }

    @Override
    public SearchHelperInterface getSearchHelper() {
        return searchHelperInterface;
    }

    @Override
    public CartHelperInterface getCartHelper(){
        return cartHelperInterface;
    }

    @Override
    public ViewItemHelperInterface getViewItemHelper() {
        return viewItemHelperInterface;
    }

    public WebDriver getWebdriver(){
        return WebDriverRunner.getWebDriver();
    }

    @Step("Get current url.")
    public String getCurrentUrl() {
        String currentUrl = getWebdriver().getCurrentUrl();
        return currentUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
