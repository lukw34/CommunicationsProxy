package controller.interfaces;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Stream;

public interface MessageBoxesCtrlInterface<T extends JPanel> extends ViewController<T> {
    Stream<Component> getMessageBoxes();

    BoxCtrlInterface getRandomRecipient();

    void onParamsChange();
}
