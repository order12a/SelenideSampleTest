package dp.logic;

public interface SearchHelperInterface {
    boolean isSearchPageReady();
    void searchByKeyword(String keyword);
    boolean isSearchResultDisplayed();
    void openItemFromSearchResult(int index);
    void addItemsToCart(int[] index);

    void filterResultsByMaxAccuracy();

    void searchByContributorMinimized(String contributor);

    boolean checkContributorFilterPresent(String contributor);
}
