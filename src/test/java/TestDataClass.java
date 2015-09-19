import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;


public class TestDataClass extends  TestBase{

    @DataProvider
    public static Object[][] users() {
        return new Object[][] {
                { "usefOne", "1"},
                { "VinsOrder", "123456" }
        };
    }
}
