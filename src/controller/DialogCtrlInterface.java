package controller;


import java.awt.event.ActionEvent;

public interface DialogCtrlInterface <T>{
    void showDialog();

    void changeMessageQuantity(T numberOfMessage);

    void changeNumberOfThreads(T numberOfThreads);

    void closeDialog(ActionEvent actionEvent);
}
