package controller.implementations;

import controller.interfaces.BoxCtrlInterface;
import controller.interfaces.MessageBoxesCtrlInterface;
import models.InitParamsInterface;
import utils.AppConfig;
import views.MessageBoxes;
import views.SimpleView;

import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Stream;

public class MessageBoxesCtrl implements MessageBoxesCtrlInterface<MessageBoxes>{

    private SimpleView<MessageBoxes> messageBoxesView;
    private InitParamsInterface initParams;
    private int messageBoxesQuantiy = AppConfig.MAX_NUMBER_OF_THREADS;

    private ArrayList<BoxCtrlInterface> boxCtrls;

    public MessageBoxesCtrl(InitParamsInterface initParams) {
        this.initParams = initParams;
        messageBoxesView = new MessageBoxes(this);
        boxCtrls = new ArrayList<>();

        for (int messageBoxIndex = 0; messageBoxIndex < messageBoxesQuantiy; messageBoxIndex++) {
            boxCtrls.add(new MessageBoxCtrl("Thread" + messageBoxIndex, this));
        }
    }

    @Override
    public MessageBoxes render() {
        return messageBoxesView.drawView();
    }


    @Override
    public Stream<Component> getMessageBoxes() {
        return boxCtrls.stream().map(BoxCtrlInterface::render);
    }

    @Override
    public BoxCtrlInterface getRandomRecipient() {
        int randomIndex = (int)(Math.random() * initParams.getNumberOfThreaads());
        return boxCtrls.get(randomIndex);
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
        }
    }
}
