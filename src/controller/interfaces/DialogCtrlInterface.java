package controller.interfaces;


import java.awt.*;
import java.awt.event.ActionEvent;

public interface DialogCtrlInterface<T, V extends Component> extends ViewController<V> {
    void showDialog();

    void changeMessageQuantity(T numberOfMessage);

    void changeNumberOfThreads(T numberOfThreads);

    void closeDialog(ActionEvent actionEvent);

    void addSubscriber(DialogSubscriber viewController);
}
