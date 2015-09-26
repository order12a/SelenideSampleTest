package logic.ready;

import dp.logic.SearchHelperInterface;
import org.openqa.selenium.WebDriver;

public class SearchHelper extends DriverBasedHelper implements SearchHelperInterface{

    public SearchHelper(ApplicationManager manager) {
        super(manager.getWebdriver());
    }

    public boolean isSearchPageReady() {
        return pages.searchPage.ensurePageLoaded();
    }

    public void searchByKeyword(String keyword) {
        pages.searchPage.searchByKeyword(keyword);
        pages.searchPage.ensurePageLoaded();
    }

    public boolean isSearchResultDisplayed() {
        return pages.searchPage.isSearchResultDisplayed();
    }

    public void openItemFromSearchResult(int index) {
        pages.searchPage.clickAtResultItem(index);
    }

    public void addItemsToCart(int[] index) {
        pages.searchPage.addToCart(index);
    }
}
