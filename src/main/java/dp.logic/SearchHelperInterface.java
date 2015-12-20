package dp.logic;

import model.Content;

public interface SearchHelperInterface {
    boolean isSearchPageReady();

    void searchByKeyword(String keyword);

    boolean isSearchResultDisplayed();

    void openItemFromSearchResult(int index);

    void addItemsFromSearchToCart(int[] index);

    void searchByContributorMinimized(String contributor);

    boolean checkContributorFilterPresent(String contributor);

    boolean isSearchFieldFilledWithRequest(String searchRequest);

    void searchFromMainPage(String searchRequest);

    void searchByKeywordWithContent(String searchRequest, Content content);

    boolean isSearchContentEqualTo(Content content);
}
