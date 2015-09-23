import com.codeborne.selenide.WebDriverRunner;
import dp.logic.ApplicationManagerInterface;
import logic.ready.ApplicationManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import temporary.PageInit;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    final String KEY = "run";
    final String URL = "http://depositphotos.com";
    public PageInit pageInit = new PageInit();
    private static Logger LOG = LogManager.getLogger(TestBase.class);
//    final String LOG_FILE = "/main/java/resources/log4j.properties";
    public static ApplicationManagerInterface app;

    @BeforeClass
    public static void setUp(){

        DesiredCapabilities capabilities;
        capabilities = DesiredCapabilities.chrome();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1400,1200");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        WebDriverRunner.setWebDriver(new ChromeDriver(capabilities));
        app = new ApplicationManager();
//      WebDriverRunner.setWebDriver(new FirefoxDriver());

    }


    @AfterClass
    public static void tearDown(){
        WebDriverRunner.closeWebDriver();
        if (WebDriverRunner.getWebDriver() != null){
            LOG.info("Still have webdriver instances - " + WebDriverRunner.getWebDriver() != null);
            try {
                WebDriverRunner.getWebDriver().quit();
                LOG.info("Check webdriver instances after quit, status of present instances- " + WebDriverRunner.getWebDriver() != null);
            }catch (Exception e){
//                killAllProcesses("chrome");
                WebDriverRunner.getWebDriver().quit();
            }
        }
    }


    public void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
