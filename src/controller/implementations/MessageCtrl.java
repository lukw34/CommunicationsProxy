package controller.implementations;

import controller.implementations.message.MessageEmpty;
import controller.implementations.message.MessageProcessing;
import controller.implementations.message.MessageWaiting;
import controller.interfaces.MessageCtrlInterface;
import controller.interfaces.MessageState;
import views.Message;
import views.SimpleView;

import java.awt.*;

public class MessageCtrl implements MessageCtrlInterface<Message> {

    MessageState message;
    MessageState empty;
    MessageState processing;

    MessageState actualState;

    SimpleView<Message> messageView;

    MessageCtrl() {
        messageView = new Message(this);
        empty = new MessageEmpty();
        message = new MessageWaiting(this);
        processing = new MessageProcessing();
        actualState  = empty;
    }

    @Override
    public void setState(MessageState state) {
        actualState = state;

    }

    @Override
    public void paint(Graphics g) {
        actualState.paint(g, new Point(0, 0));
    }

    @Override
    public void repaint() {
        messageView.repaint();
    }

    @Override
    public MessageState getEmpty() {
        return empty;
    }

    @Override
    public MessageState getMessage() {
        return message;
    }

    @Override
    public void sendIfPossible() throws InterruptedException {
        if(actualState.canProcessing()) {
            Thread.sleep(2000);
            this.setState(this.message);
            this.repaint();

            new Thread(() -> {
               int randdom = (int)( Math.random() * 2);
                System.out.println(randdom);
                if(randdom == 1) {
                    this.setState(this.empty);
                    this.repaint();
                }
            }).start();
        }
    }

    @Override
    public Message render() {
        return messageView.drawView();
    }

}
