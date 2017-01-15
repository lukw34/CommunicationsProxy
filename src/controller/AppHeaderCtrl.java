package controller;

import views.Header;
import views.SimpleView;

import java.awt.event.ActionEvent;

public class AppHeaderCtrl implements HeaderCtrl<Header>{

    SimpleView header;
    DialogCtrlInterface dialogCtrl;

    public AppHeaderCtrl( DialogCtrlInterface dialogCtrl) {
        this.header = new Header(this);
        this.dialogCtrl = dialogCtrl;
    }

    @Override
    public void resetParams(ActionEvent event) {
        dialogCtrl.showDialog();
    }

    @Override
    public Header render() {
        return (Header) header.drawView();
    }
}
