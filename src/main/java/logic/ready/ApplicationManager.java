package logic.ready;


import com.codeborne.selenide.WebDriverRunner;
import dp.logic.ApplicationManagerInterface;
import dp.logic.NavigationHelperInterface;
import dp.logic.SearchHelperInterface;
import dp.logic.UserHelperInterface;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import util.LogHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ApplicationManager extends LogHelper implements ApplicationManagerInterface{

    private String baseUrl;
    private String adminUrl;
    private String apiUrl;
    private UserHelperInterface userHelperInterface;
    private NavigationHelperInterface navigationHelperInterface;
    private SearchHelperInterface searchHelperInterface;

    public ApplicationManager() {
//        adminUrl = "http://admin." + baseUrl.replace("http://", "");
//        apiUrl = "http://api." + baseUrl.replace("http://", "");
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
            }catch (NoSuchElementException nE){
                WebDriverRunner.getWebDriver().getCurrentUrl();
            }
        }


    }

    public void directLogin(String user) {

    }

    public void directLogin(String user, String backUrl) {

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

    public void getCurrentUrl() {
        String currentUrl = getWebdriver().getCurrentUrl();
        logMe(currentUrl);
    }
}
