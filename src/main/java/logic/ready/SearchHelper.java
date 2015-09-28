package logic.ready;

import dp.logic.SearchHelperInterface;
import org.openqa.selenium.WebDriver;

public class SearchHelper extends DriverBasedHelper implements SearchHelperInterface{

    public SearchHelper(ApplicationManager manager) {
        super(manager.getWebdriver());
    }

    @Override
    public boolean isSearchPageReady() {
        return pages.searchPage.ensurePageLoaded();
    }

    @Override
    public void searchByKeyword(String keyword) {
        pages.searchPage.searchByKeyword(keyword);
        pages.searchPage.ensurePageLoaded();
    }

    @Override
    public boolean isSearchResultDisplayed() {
        return pages.searchPage.isSearchResultDisplayed();
    }

    @Override
    public void openItemFromSearchResult(int index) {
        pages.searchPage.clickAtResultItem(index);
    }

    @Override
    public void addItemsToCart(int[] index) {
        pages.searchPage.addToCart(index);
    }

    @Override
    public void filterResultsByMaxAccuracy() {
        pages.searchPage.ensurePageLoaded();
        pages.searchPage.isSearchResultDisplayed();
        pages.searchPage.enableMaxResultFilterAtSmallPanel();
        pages.searchPage.isSearchResultDisplayed();
    }
}
