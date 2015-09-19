import com.codeborne.selenide.WebDriverRunner;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
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
//    final String KEY = "run";
//    final String URL = "http://depositphotos.com";
//    public PageInit pageInit;

//    @BeforeClass
//    public static void setUp(){
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities = DesiredCapabilities.chrome();
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("window-size=1400,1200");
//        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//
//        WebDriverRunner.setWebDriver(new ChromeDriver(capabilities));
//      WebDriverRunner.setWebDriver(new FirefoxDriver());
//    }

    @Before
    public void before(){
//        pageInit = new PageInit();
    }

    @Test
    public void startTest(){
        open(URL);
        $("#d_search2").setValue(KEY).pressEnter();

        assertTrue("Check that search field stores request", $(By.xpath(".//input[@id='d_search4']")).getAttribute("value").contains(KEY));

        System.out.println("\n" + $(By.xpath(".//input[@id='d_search4']")).getAttribute("value").toUpperCase() + "\n");
        sleep(2);
    }

    @Test
    @UseDataProvider(value = "users", location = TestDataClass.class)
    public void loginTest(String username, String password){
        WebDriverRunner.getWebDriver().get(URL);
        pageInit.mainPageLoggedOut.clickLoginButton();
        pageInit.loginTip.login(username, password);
        sleep(5);
    }

    @After
    public void disable(){
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        WebDriverRunner.getWebDriver().navigate().refresh();
//        try {
//            System.out.println("After try - " + WebDriverRunner.hasWebDriverStarted());
//            WebDriverRunner.closeWebDriver();
//            killAllProcesses("firefox");
//            System.out.println("After try - " + WebDriverRunner.hasWebDriverStarted());
//        }catch (Exception e){
//            System.out.println("After catch - " + WebDriverRunner.hasWebDriverStarted());
//        }
    }


//    @AfterClass
//    public static void tearDown(){
//        WebDriverRunner.closeWebDriver();
//        if (WebDriverRunner.getWebDriver() != null){
//            try {
//                System.out.println("After class try - " + WebDriverRunner.hasWebDriverStarted());
//                WebDriverRunner.getWebDriver().quit();
//            }catch (Exception e){
//                killAllProcesses("chrome");
//            }
//            System.out.println("After class catch - " + WebDriverRunner.hasWebDriverStarted());
//            }
//    }

}
