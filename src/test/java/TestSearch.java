import com.codeborne.selenide.WebDriverRunner;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

@RunWith(DataProviderRunner.class)
public class TestSearch extends TestDataClass{
    String searchUrl = "http://depositphotos.com/search-all/index.html";

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
        pageManager.mainPageLoggedOut.clickLoginButton();
        pageManager.loginTip.login(username, password);
        sleep(5);
    }

    @Test
    public void testAccuracyMinimized(){
        open(searchUrl);
        Assert.assertEquals("Assert that search page not broken.", true, app.getSearchHelper().isSearchPageReady());
        app.getSearchHelper().searchByKeyword("sun");
        app.getSearchHelper().filterResultsByMaxAccuracy();
        sleep(8);
        Assert.assertEquals("Assert that we have search results.", true, app.getSearchHelper().isSearchResultDisplayed());
    }

    @After
    public void disable(){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        WebDriverRunner.getWebDriver().navigate().refresh();
    }

}
