package dp.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class MainPageLoggedIn extends AnyPage {
    public MainPageLoggedIn(WebDriver driver) {
        super(driver);
    }

    SelenideElement userIcon = $(".avatar-holder.small");
    SelenideElement usernameLine = $(".username");
    SelenideElement searchButton = $(".search-button");
    SelenideElement searchFieldHome = $("#d_search4");

    public boolean isLoggedIn(String username){
        boolean flag = true;
        ensurePageLoaded();
        flag = flag & isAvatarHolderDisplayed();
        flag = flag & isUsernameDisplayed(username);
        return flag;
    }

    public  boolean isAvatarHolderDisplayed(){
        return userIcon.isDisplayed();
    }

    public boolean isUsernameDisplayed(String username){
        usernameLine.shouldBe(Condition.visible);
        return usernameLine.getText().equalsIgnoreCase(username);
    }

    public void searchFromUserMenuLoggedIn(String keyword){
        searchFieldHome.shouldBe(Condition.visible).val(keyword);
        searchButton.waitUntil(Condition.visible, WAIT_SECONDS).click();
    }
}
