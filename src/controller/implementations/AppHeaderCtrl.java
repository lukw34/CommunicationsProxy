package controller.implementations;

import controller.interfaces.DialogCtrlInterface;
import controller.interfaces.HeaderCtrlInterface;
import views.Header;
import views.SimpleView;

import java.awt.event.ActionEvent;

public class AppHeaderCtrl implements HeaderCtrlInterface<Header> {

    SimpleView<Header> header;
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
        return header.drawView();
    }

}
