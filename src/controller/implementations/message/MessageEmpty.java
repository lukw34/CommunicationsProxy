package controller.implementations.message;

import controller.interfaces.MessageState;

import java.awt.*;

public class MessageEmpty  implements MessageState {
    @Override
    public void paint(Graphics g, Point startPoint) {
        Graphics2D g2 = (Graphics2D)g;
        g2.clearRect(0, 0, 52, 32);
    }

    @Override
    public boolean canProcessing() {
        System.out.println("Pusta wiadomość");
        return false;
    }


}
