package dp.logic;

import model.Size;

public interface PopupItemHelperInterface {
    boolean isItemInPopupOpened();
    void downloadItemInPopup(Size size);
    boolean isSizeDownloaded(Size size);
}
