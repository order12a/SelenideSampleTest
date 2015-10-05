import com.codeborne.selenide.WebDriverRunner;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@RunWith(DataProviderRunner.class)
public class TestRedirect extends TestDataClass{
    @Before
    public void before(){
        app.clearCookies();
    }

    @Test
    @UseDataProvider(value = "users", location = TestDataClass.class)
    public void redirectFromPopupWithoutPlans(String searchUrl, String username, String password){
        open(searchUrl);

    }

    @Test
    @UseDataProvider(value = "redirect_to_login_page_urls", location = TestDataClass.class)
    public void redirectToStaticLoginPage(String url, String username, String password){
        open(URL + url);
        app.getUserHelper().loginStatic(username, password);
        Assert.assertTrue(app.getUserHelper().isLoggedIn(username));
    }
}
