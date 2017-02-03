package views;

import controller.interfaces.MessageCtrlInterface;

import javax.swing.*;
import java.awt.*;

public class Message extends JPanel implements  SimpleView<Message> {

    MessageCtrlInterface messageCtrl;

    public Message(MessageCtrlInterface messageCtrl) {
        this.messageCtrl = messageCtrl;
    }

    @Override
    public void paintComponent(Graphics g) {
        messageCtrl.paint(g);
    }

    @Override
    public Message drawView() {
        return this;
    }
}