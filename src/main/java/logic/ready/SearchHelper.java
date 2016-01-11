package logic.ready;

import dp.logic.SearchHelperInterface;
import model.Content;

public class SearchHelper extends DriverBasedHelper implements SearchHelperInterface{

    public SearchHelper(ApplicationManager manager) {
        super(manager.getWebdriver());
    }

    @Override
    public boolean isSearchFieldFilledWithRequest(String searchRequest) {
        pages.searchPage.ensurePageLoaded();
        return pages.searchPage.hasSearchFieldKeyword(searchRequest);
    }

    @Override
    public void searchFromMainPage(String searchRequest) {
        pages.mainPageLoggedOut.ensurePageLoaded();
        pages.mainPageLoggedOut.searchByKeyword(searchRequest);
    }

    @Override
    public void searchByKeywordWithContent(String searchRequest, Content content) {
        //TODO implement
    }

    @Override
    public boolean isSearchContentEqualTo(Content content) {
        //TODO implement
        return false;
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
    public void addItemsFromSearchToCart(int[] index) {
        pages.searchPage.addToCart(index);
    }

    @Override
    public void searchByContributorMinimized(String contributor) {
        pages.searchPage.ensurePageLoaded();
        pages.searchPage.searchByContributorMinimized(contributor);
        pages.searchPage.ensurePageLoaded();
    }

    @Override
    public boolean checkContributorFilterPresent(String contributor) {
        pages.searchPage.ensurePageLoaded();
        return pages.searchPage.checkContributorFilterPresent(contributor);
    }

    @Override
    public void searchFromHome(String keyword) {
        pages.mainPageLoggedIn.searchFromUserMenuLoggedIn(keyword);
    }
}
