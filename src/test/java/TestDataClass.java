import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;


public class TestDataClass extends  TestBase{
    final String KEY = "run";
    final String URL = "http://depositphotos.com";

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
                {"http://depositphotos.com/search-all/index.html", "igor_kali"}
        };
    }

    @DataProvider
    public static Object[][] serch_by_keyword(){
        return new Object[][]{
                {"beach woman"}
        };
    }
}
