package dp.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface PassworRecoveryPopup {
    SelenideElement userNameFieldP = $(".d-input[name=username]");
    SelenideElement userEmailFieldP = $(".d-input[name=email]");
    SelenideElement sendResetLink = $(".button.l.blue.d-sendLink");
    SelenideElement promptOkButton = $(By.xpath("(//button[@class='button l blue'])[1]"));
    SelenideElement closePopupButton = $(By.xpath("//div[contains(@class, 'popup-close')]"));

    default void resetPasswordViaEmail(String email){
        userEmailFieldP.shouldBe(Condition.visible).val(email);
        clickResetLink();
        promptOkButton.shouldBe(Condition.visible).click();
    }

    default void resetPasswordViaUsername(String username){
        userNameFieldP.shouldBe(Condition.visible).val(username);
        clickResetLink();
        promptOkButton.shouldBe(Condition.visible).click();
    }

    default void clickResetLink(){
        sendResetLink.shouldBe(Condition.visible).click();
    }

    default boolean isPopupDisplayed(){
        return closePopupButton.isDisplayed();
    }

    default void closePopup(){
        closePopupButton.shouldBe(Condition.visible).click();
    }
}
