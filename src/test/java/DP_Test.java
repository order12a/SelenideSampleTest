import com.codeborne.selenide.WebDriverRunner;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import temporary.PageInit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class DP_Test {
    final String KEY = "run";
    final String URL = "http://depositphotos.com";
    public PageInit pageInit;

    @BeforeClass
    public static void setUp(){

    }

    @Before
    public void before(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities = DesiredCapabilities.chrome();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1400,1200");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        WebDriverRunner.setWebDriver(new ChromeDriver(capabilities));
//        WebDriverRunner.setWebDriver(new FirefoxDriver());
        pageInit = new PageInit();
    }

    @Test
    public void startTest(){
        open(URL);
        $("#d_search2").setValue(KEY).pressEnter();

        assertTrue($(By.xpath(".//input[@id='d_search4']")).getAttribute("value").contains(KEY));
        System.out.println("\n" + $(By.xpath(".//input[@id='d_search4']")).getAttribute("value").toUpperCase() + "\n");
    }

    @After
    public void disable(){
        try {
            System.out.println("After try - " + WebDriverRunner.hasWebDriverStarted());
            WebDriverRunner.closeWebDriver();
//            killAllProcesses("firefox");
            System.out.println("After try - " + WebDriverRunner.hasWebDriverStarted());
        }catch (Exception e){
            System.out.println("After catch - " + WebDriverRunner.hasWebDriverStarted());
        }
    }

    @AfterClass
    public static void tearDown(){
        if (WebDriverRunner.hasWebDriverStarted()){
            try {
                System.out.println("After class try - " + WebDriverRunner.hasWebDriverStarted());
                WebDriverRunner.getWebDriver().quit();
            }catch (Exception e){
                killAllProcesses("chrome");
            }
            System.out.println("After class catch - " + WebDriverRunner.hasWebDriverStarted());
            }
    }

    public static void killAllProcesses(String typeOfBrowser) {
        try {
            if (typeOfBrowser.equalsIgnoreCase("firefox") || typeOfBrowser.equalsIgnoreCase("mozilla firefox")) {
                Process process = Runtime.getRuntime().exec(
                        "Taskkill /IM firefox.exe /F");
                process.waitFor();
                System.out.println("All Firefox processes are closed.");
            } else if (typeOfBrowser.equalsIgnoreCase("chrome") || typeOfBrowser.equalsIgnoreCase("google chrome")) {
                Process process = Runtime.getRuntime().exec(
                        "Taskkill /IM chrome.exe /F");
                process.waitFor();
                System.out.println("All Google Chrome processes are closed.");
            } else if (typeOfBrowser.equalsIgnoreCase("explorer") || typeOfBrowser.equalsIgnoreCase("internet explorer") || typeOfBrowser.equalsIgnoreCase("ie")) {
                Process process = Runtime.getRuntime().exec(
                        "Taskkill /IM iexplore.exe /F");
                process.waitFor();
                System.out.println("All Internet Explorer processes are closed.");
            } else if (typeOfBrowser.equalsIgnoreCase("opera")) {
                Process process = Runtime.getRuntime().exec(
                        "Taskkill /IM opera.exe /F");
                process.waitFor();
                System.out.println("All Opera processes are closed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
