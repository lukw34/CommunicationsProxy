package controller;

import java.awt.*;
import java.awt.event.ActionEvent;

public interface HeaderCtrl<T extends Component> extends ViewController<T> {
    void resetParams(ActionEvent event);
}
