package controller.interfaces;

import models.MessageBox;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Stream;

public interface MessageBoxesCtrlInterface<T extends JPanel> extends ViewController<T> {
    public boolean messageBoxIsReady(MessageBox messageBox);

    Stream<Component> getMessageBoxes();

    void onParamsChange();
}
