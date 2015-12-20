package bases;

import bases.TestBase;

import com.tngtech.java.junit.dataprovider.DataProvider;


public class TestDataClass extends TestBase {
    protected final String KEY = "run";
    protected final String BASE_URL = "http://depositphotos.com";

    @DataProvider
    public static Object[][] users() {
        return new Object[][] {
                { "usefOne", "1"},
                { "VinsOrder", "123456" }
        };
    }

    @DataProvider
    public static Object[][] search_by_contributor(){
        return new Object[][]{
                {"/search-all/index.html", "igor_kali"}
        };
    }

    @DataProvider
    public static Object[][] serch_by_keyword(){
        return new Object[][]{
                {"beach woman"}
        };
    }

    @DataProvider
    public static Object[][] redirect_to_login_page_urls(){
        return new Object[][]{
                {"/home.html", "usefOne", "1"},
                {"/credits.html", "usefOne", "1"},
                {"/profile.html", "usefOne", "1"},
                {"/favorites.html", "usefOne", "1"},
                {"/subaccounts.html", "usefOne", "1"}
        };
    }
}
