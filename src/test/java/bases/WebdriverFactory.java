package bases;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebdriverFactory {

    public static WebDriver getWebdriver(String browser){

        if (browser.equalsIgnoreCase("chrome")){
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("window-size=1600,1200");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            WebDriverRunner.setWebDriver(new ChromeDriver(capabilities));
        }else if(browser.equalsIgnoreCase("firefox")){
            WebDriverRunner.setWebDriver(new FirefoxDriver());
            WebDriverRunner.getWebDriver().manage().window().setSize(new Dimension(1600, 1200));
        }

        return WebDriverRunner.getWebDriver();
    }
}
