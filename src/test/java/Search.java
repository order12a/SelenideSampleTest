import bases.TestDataClass;
import com.codeborne.selenide.WebDriverRunner;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import model.Content;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Parameter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

@RunWith(DataProviderRunner.class)
public class Search extends TestDataClass {
    String searchUrl = "http://depositphotos.com/search-all/index.html";

    @Before
    public void before(){
        app.clearCookies();
    }

//    @Ignore
//    @Test
//    public void testAccuracyMinimized(){
//        open(searchUrl);
//        Assert.assertEquals("Assert that search page not broken.", true, app.getSearchHelper().isSearchPageReady());
//        app.getSearchHelper().searchByKeyword("sun");
//        app.getSearchHelper().filterResultsByMaxAccuracy();
//        sleep(8);
//        Assert.assertEquals("Assert that we have search results.", true, app.getSearchHelper().isSearchResultDisplayed());
//    }

    @Test
    @Description("Test Search by keyword {0} from landing page")
    @UseDataProvider(value = "search_by_keyword", location = TestDataClass.class)
    public void searchFromMainPageLoggedOut(@Parameter("keyword") String searchRequest){
        app.getSearchHelper().searchFromMainPage(searchRequest);
        Assert.assertEquals("Assert that we have search results.", true, app.getSearchHelper().isSearchResultDisplayed());
        Assert.assertEquals("Assert keyword at the search field present.", true, app.getSearchHelper().isSearchFieldFilledWithRequest(searchRequest));
    }

    @Test
    @Description("Test Search by keyword {0} with content filter {1}")
    @UseDataProvider(value = "search_by_keyword", location = TestDataClass.class)
    public void searchByKeywordWithContentType(@Parameter("keyword") String searchRequest, @Parameter("content") Content content){
        app.getSearchHelper().searchByKeywordWithContent(searchRequest, content);
        Assert.assertEquals("Assert that we have search results.", true, app.getSearchHelper().isSearchResultDisplayed());
        Assert.assertEquals("Assert keyword at the search field present.", true, app.getSearchHelper().isSearchFieldFilledWithRequest(searchRequest));
        Assert.assertTrue("Assert correct content type filter enabled.", app.getSearchHelper().isSearchContentEqualTo(content));
    }

    @Test
    @Description("Test Search function using filter by contributor {1}.")
    @UseDataProvider(value = "search_by_contributor", location = TestDataClass.class)
    public void searchByContributorMinimized(String url, String contributor){
        open(BASE_URL + url);
        Assert.assertEquals("Assert that search page not broken.", true, app.getSearchHelper().isSearchPageReady());
        app.getSearchHelper().searchByContributorMinimized(contributor);
        Assert.assertEquals("Assert that we have search results.", true, app.getSearchHelper().isSearchResultDisplayed());
        Assert.assertEquals("Assert filter by contributor present", true, app.getSearchHelper().checkContributorFilterPresent(contributor));
    }

//    @Ignore
//    @After
//    public void disable(){
//        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
//        WebDriverRunner.getWebDriver().navigate().refresh();
//    }
}
