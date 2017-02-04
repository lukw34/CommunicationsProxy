package views;

import controller.interfaces.MessageCtrlInterface;

import javax.swing.*;
import java.awt.*;

public class MessageView extends JPanel implements  SimpleView<MessageView> {

    MessageCtrlInterface messageCtrl;

    public MessageView(MessageCtrlInterface messageCtrl) {
        this.messageCtrl = messageCtrl;
    }

    @Override
    public void paintComponent(Graphics g) {
        messageCtrl.paint(g);
    }

    @Override
    public MessageView drawView() {
        return this;
    }
}