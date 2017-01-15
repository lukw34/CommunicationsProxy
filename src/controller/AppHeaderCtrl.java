package controller;

import views.Header;
import views.SimpleView;

public class AppHeaderCtrl implements HeaderCtrl<Header>{

    SimpleView header;
    DialogCtrlInterface dialogCtrl;

    public AppHeaderCtrl( DialogCtrlInterface dialogCtrl) {
        this.header = new Header();
        this.dialogCtrl = dialogCtrl;
    }

    @Override
    public void resetParams() {
        dialogCtrl.showDialog();
    }

    @Override
    public Header render() {
        return (Header) header.drawView();
    }
}
