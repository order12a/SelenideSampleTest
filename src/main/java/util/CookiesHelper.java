package util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Date;
import java.util.Set;

public class CookiesHelper {
    private WebDriver driver;
    private static Logger LOG = LogManager.getLogger(CookiesHelper.class);

    public CookiesHelper(WebDriver drv) {
        driver = drv;
    }

    public void addCookie (String name, String value){
        Cookie ck = new Cookie(name, value);
        driver.manage().addCookie(ck);
    }

    public void addCookie (Cookie cookie){
        driver.manage().addCookie(cookie);
    }

    public void addCookie (String name, String value, String domain, String path, Date expiry){
        Cookie ck = new Cookie(name, value, domain, path, expiry);
        driver.manage().addCookie(ck);
    }

    public void removeCookie(String name) {
        driver.manage().deleteCookieNamed(name);
    }

    public void printCookies (){
        Set<Cookie> userCookies = driver.manage().getCookies();
        for (Cookie cookie : userCookies) {
            System.out.print("\n" + cookie.getName() + "\n");
            System.out.print(cookie.getValue() + "\n");
        }
    }

    public Set<Cookie> getAllCookies(){
        return driver.manage().getCookies();
    }

    public boolean checkCookieNamedPresent(String cookieName){
        if (!cookieName.isEmpty()){
           for (Cookie cookie:getAllCookies()){
               if (cookie.getName().equals(cookieName)){
                   return true;
               }
           }
        }else {
            LOG.info("Enter cookie name.");
        }
        return false;
    }

    public boolean checkCookieValuePresent(String cookieName){
        if (!cookieName.isEmpty()){
            for (Cookie cookie:getAllCookies()){
                if (cookie.getValue().equals(cookieName)){
                    return true;
                }
            }
        }else {
            LOG.info("Enter cookie name.");
        }
        return false;
    }
}
