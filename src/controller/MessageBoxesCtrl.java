package controller;

import models.InitParamsInterface;
import models.MessageBox;
import views.MessageBoxes;
import views.SimpleView;

public class MessageBoxesCtrl implements MessageBoxesCtrlInterface<MessageBoxes>, Runnable {

    SimpleView<MessageBoxes> messageBoxesView;
    InitParamsInterface initParams;

    public MessageBoxesCtrl(InitParamsInterface initParams) {
        this.initParams = initParams;
        messageBoxesView = new MessageBoxes(this);
    }

    @Override
    public MessageBoxes render() {
        return messageBoxesView.drawView();
    }

    @Override
    public void reRender() {
        messageBoxesView.repaint();
        System.out.println("rerender");
        messageBoxesView.setVisible(false);
        messageBoxesView.setVisible(true);
    }

    @Override
    public void run() {

    }
    @Override
    public boolean messageBoxIsReady(MessageBox messageBox) {
        return false;
    }

    @Override
    public int getActivemessageBoxes() {
        return initParams.getNumberOfThreaads();
    }
}
