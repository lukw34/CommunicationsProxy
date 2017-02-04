package controller.implementations;

import controller.interfaces.DialogCtrlInterface;
import controller.interfaces.HeaderCtrlInterface;
import views.Header;
import views.SimpleView;

public class AppHeaderCtrl implements HeaderCtrlInterface<Header> {

    SimpleView<Header> header;
    DialogCtrlInterface dialogCtrl;

    public AppHeaderCtrl( DialogCtrlInterface dialogCtrl) {
        this.header = new Header();
        this.dialogCtrl = dialogCtrl;
    }

    /**
     * Metoda udostepnijaca widok.
     *
     * @return Wyrenderowany widok
     */
    @Override
    public Header render() {
        return header.drawView();
    }

}
