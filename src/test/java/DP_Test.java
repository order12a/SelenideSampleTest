import com.codeborne.selenide.WebDriverRunner;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import static org.hamcrest.Matchers.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import temporary.PageInit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

@RunWith(DataProviderRunner.class)
public class DP_Test extends TestDataClass{

    @Before
    public void before(){
        app.clearCookies();
    }

    @Ignore
    @Test
    public void startTest(){
        open(URL);
        $("#d_search2").setValue(KEY).pressEnter();

        assertTrue("Check that search field stores request", $(By.xpath(".//input[@id='d_search4']")).getAttribute("value").contains(KEY));

        System.out.println("\n" + $(By.xpath(".//input[@id='d_search4']")).getAttribute("value").toUpperCase() + "\n");
        sleep(2);
    }

    @Ignore
    @Test
    @UseDataProvider(value = "users", location = TestDataClass.class)
    public void loginTest(String username, String password){
        WebDriverRunner.getWebDriver().get(URL);
        pageInit.mainPageLoggedOut.clickLoginButton();
        pageInit.loginTip.login(username, password);
        sleep(5);
    }

    @Test
    @UseDataProvider(value = "users", location = TestDataClass.class)
    public void loginTestWithSteps(String username, String password){
        WebDriverRunner.getWebDriver().get(URL);
        app.getNavigationHelper().openMainPage();
        app.getUserHelper().login(username, password);
        Assert.assertTrue(app.getUserHelper().isLoggedIn(username));
    }

    @After
    public void disable(){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        WebDriverRunner.getWebDriver().navigate().refresh();
    }

}
