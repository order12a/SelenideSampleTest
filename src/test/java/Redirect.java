import bases.TestDataClass;
import com.codeborne.selenide.WebDriverRunner;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import model.Size;
import org.junit.*;
import org.junit.runner.RunWith;
import ru.yandex.qatools.allure.annotations.Description;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@RunWith(DataProviderRunner.class)
public class Redirect extends TestDataClass {
    @Before
    public void before(){
        app.clearCookies();
    }

    @Test
    @UseDataProvider(value = "users", location = TestDataClass.class)
    public void redirectFromPopupWithoutPlans(String searchUrl, String username, String password, String url){
        open(BASE_URL + searchUrl);
        String expectedUrl = "";
        app.getSearchHelper().openItemFromSearchResult(1);
        app.getUserHelper().downloadItem(Size.M);
        app.getUserHelper().login(username, password);
        app.getUserHelper().isUserRedirectedTo(expectedUrl);
    }

    @Test
    @Description("Redirect to login page when user attempt ot access pages that denied in logout.")
    @UseDataProvider(value = "redirect_to_login_page_urls", location = TestDataClass.class)
    public void redirectToStaticLoginPage(String url, String username, String password){
        open(BASE_URL + url);
        app.getUserHelper().loginStatic(username, password);
        Assert.assertTrue("User is not logged in.", app.getUserHelper().isLoggedIn(username));
        Assert.assertTrue("Url after login is not equal to expected " + url, (app.getCurrentUrl().contains(url)));
    }

//    @Ignore
//    @After
//    public void disable(){
//        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
//        WebDriverRunner.getWebDriver().navigate().refresh();
//    }
}
