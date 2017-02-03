package controller.interfaces;

import java.awt.*;
import java.awt.event.ActionEvent;

public interface HeaderCtrlInterface<T extends Component> extends ViewController<T> {
    void resetParams(ActionEvent event);
}
