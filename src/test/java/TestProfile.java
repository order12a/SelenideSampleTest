import com.codeborne.selenide.WebDriverRunner;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.*;
import org.junit.runner.RunWith;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

@RunWith(DataProviderRunner.class)
public class TestProfile extends TestDataClass{
    String staticLoginUrl = "http://depositphotos.com/login.html";

    @Before
    public void before(){
        app.clearCookies();
    }

    @Test
    @UseDataProvider(value = "users", location = TestDataClass.class)
    public void loginTestWithSteps(String username, String password){
        WebDriverRunner.getWebDriver().get(URL);
        app.getNavigationHelper().openMainPage();
        app.getUserHelper().login(username, password);
        Assert.assertTrue(app.getUserHelper().isLoggedIn(username));
    }

    @Test
    @UseDataProvider(value = "users", location = TestDataClass.class)
    public void loginTestStatic(String username, String password){
        open(staticLoginUrl);
        app.getUserHelper().loginStatic(username, password);
        Assert.assertTrue(app.getUserHelper().isLoggedIn(username));
    }

    @After
    public void disable(){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        WebDriverRunner.getWebDriver().navigate().refresh();
    }
}
