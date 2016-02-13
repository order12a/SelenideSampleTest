package bases;

import com.codeborne.selenide.WebDriverRunner;
import dp.logic.ApplicationManagerInterface;
import logic.ready.ApplicationManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.yandex.qatools.allure.annotations.Attachment;
import dp.pages.PageManager;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import ru.qatools.properties.PropertyLoader;
import util.config.EnvironmentConfig;

public class TestBase {

    public PageManager pageManager = new PageManager();
    private static Logger LOG = LogManager.getLogger(TestBase.class);
//    final String LOG_FILE = "/main/java/resources/log4j.properties";
    protected static String baseUrl;
    public static ApplicationManagerInterface app;

    @BeforeClass
    public static void setUp(){
        System.setProperty("selenide.screenshots", "false");
        System.setProperty("selenide.reopenBrowserOnFail", "true");
        EnvironmentConfig config = PropertyLoader.newInstance().populate(EnvironmentConfig.class);
        baseUrl = config.getBaseUrl();

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1400,1200");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        WebDriverRunner.setWebDriver(new ChromeDriver(capabilities));
        app = new ApplicationManager();
//      WebDriverRunner.setWebDriver(new FirefoxDriver());
    }

    @Rule
    public JUnitRetry retry = new JUnitRetry(2);

    @Rule
    public TestWatcher screenshotOnFailure = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            app.getCurrentUrl();
            makeScreenshotOnFailure();
        }

        @Attachment("Screen shot on failure")
        public byte[] makeScreenshotOnFailure() {
            return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        }
    };



    @AfterClass
    public static void tearDown(){
//        WebDriverRunner.closeWebDriver();
//        if (WebDriverRunner.getWebDriver() != null){
//            LOG.info("Still have webdriver instances - " + WebDriverRunner.getWebDriver() != null);
//            try {
//                WebDriverRunner.getWebDriver().quit();
//                LOG.info("Check webdriver instances after quit, status of present instances- " + WebDriverRunner.getWebDriver() != null);
//            }catch (Exception e){
////                killAllProcesses("chrome");
//                WebDriverRunner.getWebDriver().quit();
//            }
//        }
        WebDriverRunner.getWebDriver().quit();
    }


    public void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
