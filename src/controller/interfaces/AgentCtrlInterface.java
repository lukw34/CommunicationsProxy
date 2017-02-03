package controller.interfaces;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Stream;

public interface AgentCtrlInterface<T extends JPanel> extends ViewController<T> {
    Stream<Component> getMessages();

    void onParamsChange();

    void unlock();
}
