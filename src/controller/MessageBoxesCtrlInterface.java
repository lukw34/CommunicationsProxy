package controller;

import models.MessageBox;

import javax.swing.*;

public interface MessageBoxesCtrlInterface<T extends JPanel> extends ViewController<T> {
    public boolean messageBoxIsReady(MessageBox messageBox);

    public int getActivemessageBoxes();
}
