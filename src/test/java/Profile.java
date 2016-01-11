import bases.TestDataClass;
import com.codeborne.selenide.WebDriverRunner;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Parameter;

import static com.codeborne.selenide.Selenide.open;

@RunWith(DataProviderRunner.class)
public class Profile extends TestDataClass {
    String staticLoginUrl = "http://depositphotos.com/login.html";

    @Before
    public void before(){
        app.clearCookies();
    }

    @Test
    @Description("Login user via tip.")
    @UseDataProvider(value = "users", location = TestDataClass.class)
    public void loginViaTip(@Parameter("login") String username, @Parameter("password") String password){
        WebDriverRunner.getWebDriver().get(BASE_URL);
        app.getNavigationHelper().openMainPage();
        app.getUserHelper().login(username, password);
        Assert.assertTrue(app.getUserHelper().isLoggedIn(username));
    }

    @Test
    @Description("Login user at static login page.")
    @UseDataProvider(value = "users", location = TestDataClass.class)
    public void loginTestStatic(@Parameter("login") String username, @Parameter("password") String password){
        open(staticLoginUrl);
        app.getUserHelper().loginStatic(username, password);
        Assert.assertTrue(app.getUserHelper().isLoggedIn(username));
    }

    @Test
    @Description("Register new buyer test.")
    public void registerNewBuyer(){
        app.getNavigationHelper().openSignUpPage();
        User buyer = app.getUserHelper().registerNewUser();
        app.getUserHelper().skipCompleteProfileStep();
        app.getUserHelper().isLoggedIn("targetUser");
    }

}
