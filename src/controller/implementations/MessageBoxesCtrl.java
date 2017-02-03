package controller.implementations;

import controller.interfaces.BoxCtrlInterface;
import controller.interfaces.DialogSubscriber;
import controller.interfaces.MessageBoxesCtrlInterface;
import utils.AppConfig;
import models.InitParamsInterface;
import models.MessageBox;
import views.MessageBoxes;
import views.SimpleView;

import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Stream;

public class MessageBoxesCtrl implements MessageBoxesCtrlInterface<MessageBoxes>, DialogSubscriber, Runnable{

    private SimpleView<MessageBoxes> messageBoxesView;
    private InitParamsInterface initParams;
    private int messageBoxesQuantiy = AppConfig.MAX_NUMBER_OF_THREADS;

    private ArrayList<BoxCtrlInterface> boxCtrls;

    public MessageBoxesCtrl(InitParamsInterface initParams) {
        this.initParams = initParams;
        messageBoxesView = new MessageBoxes(this);
        boxCtrls = new ArrayList<>();

        for (int messageBoxIndex = 0; messageBoxIndex < messageBoxesQuantiy; messageBoxIndex++) {
            boxCtrls.add(new MessageBoxCtrl());
        }
    }


    @Override
    public MessageBoxes render() {
        return messageBoxesView.drawView();
    }

    @Override
    public boolean messageBoxIsReady(MessageBox messageBox) {
        return false;
    }

    @Override
    public Stream<Component> getMessageBoxes() {
        return boxCtrls.stream().map(BoxCtrlInterface::render);
    }

    @Override
    public void onParamsChange() {
        for (int index = 0; index < messageBoxesQuantiy; index++) {
            BoxCtrlInterface box = boxCtrls.get(index);
            if (index < initParams.getNumberOfThreaads()) {
                box.setState(box.getReady());
            } else {
                box.setState(box.getEmpty());
            }

            box.repaint();
        }
    }

    @Override
    public void run() {
        BoxCtrlInterface previouseBox = null;
        for (int messageBoxIndex = 0; messageBoxIndex < messageBoxesQuantiy; messageBoxIndex++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
