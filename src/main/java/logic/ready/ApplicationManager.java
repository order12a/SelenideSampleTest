package logic.ready;

import com.codeborne.selenide.WebDriverRunner;
import dp.logic.ApplicationManagerInterface;
import dp.logic.NavigationHelperInterface;
import dp.logic.SearchHelperInterface;
import dp.logic.UserHelperInterface;
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
//    protected WebDriver driver;

    public ApplicationManager() {
//      baseUrl = PropertyLoader.loadProperty("site.url");

        userHelperInterface = new UserHelper(this);
        navigationHelperInterface = new NavigationHelper(this);
        searchHelperInterface = new SearchHelper(this);
    }

    public void clearCookies() {
        if(WebDriverRunner.getWebDriver() != null && WebDriverRunner.getWebDriver().getWindowHandles().size() > 0){
            try {
                WebDriverRunner.getWebDriver().manage().deleteAllCookies();
                WebDriverRunner.clearBrowserCache();
                WebDriverRunner.getWebDriver().navigate().refresh();
            }catch (WebDriverException e){
                WebDriverRunner.getWebDriver().getCurrentUrl();
                e.printStackTrace();
            }
        }

        open(baseUrl);
    }

    @Step("Direct login of current user.")
    public void directLogin(User user) {

    }

    @Step("Direct login of current user. With target url {1}")
    public void directLogin(String baseURL, User user, String backUrl) {
        System.out.println(baseURL + "/login.html?username=" + user.getUsername() + "&password=" + user.getPassword() + "&backURL[page]=" + backUrl);
        open(baseURL + "/login.html?username=" + user.getUsername() + "&password=" + user.getPassword() + "&backURL[page]=" + backUrl);
        pages.anyPage.ensurePageLoaded();
        pages.anyPage.waitForAjaxResponse(15);
    }

    @Step("Direct logout from user account: {0}")
    public void directLogout(String baseURL) {
//        logMe();
        open(baseURL + "/login/logout.html?backURL=login.html");
    }

    public boolean isProd() {
        return false;
    }

    public NavigationHelperInterface getNavigationHelper() {
        return navigationHelperInterface;
    }

    public UserHelperInterface getUserHelper() {
        return userHelperInterface;
    }

    public SearchHelperInterface getSearchHelper() {
        return searchHelperInterface;
    }

    public WebDriver getWebdriver(){
        return WebDriverRunner.getWebDriver();
    }

    @Step("Get current url.")
    public void getCurrentUrl() {
        String currentUrl = getWebdriver().getCurrentUrl();
//        logMe(currentUrl);
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
