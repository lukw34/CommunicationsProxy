package controller.implementations;

import controller.interfaces.DialogCtrlInterface;
import controller.interfaces.DialogSubscriber;
import models.InitParamsInterface;
import views.ConfigDialog;
import views.SimpleView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ConfigDialogCtrl implements DialogCtrlInterface<Integer, ConfigDialog> {

    SimpleView<ConfigDialog> configDialogSimpleView;
    InitParamsInterface initParams;

    ArrayList<DialogSubscriber> subscribers;

    public ConfigDialogCtrl(InitParamsInterface initParams, JFrame parent) {
        this.initParams = initParams;
        this.configDialogSimpleView = new ConfigDialog(parent, this);
        subscribers = new ArrayList<>();
    }

    @Override
    public void showDialog() {
        configDialogSimpleView.setVisible(true);
    }

    @Override
    public void changeMessageQuantity(Integer numberOfMessages) {
        initParams.setMessageQuantity(numberOfMessages);
    }

    @Override
    public void changeNumberOfThreads(Integer numberOfThreads) {
        initParams.setNumberOfThreaads(numberOfThreads);
    }

    @Override
    public void closeDialog(ActionEvent event) {
        subscribers.forEach(DialogSubscriber::onSubmit);
        configDialogSimpleView.setVisible(false);
    }


    /**
     * Dodaje kontrollery, które zosta poinformowane, gdy okno dialogowe zostanie zamkniete.
     *
     * @param viewController Kontroler korzystajacy z danych podawanych w oknie dialogowym
     */
    @Override
    public void addSubscriber(DialogSubscriber viewController) {
        subscribers.add(viewController);
    }

    /**
     * Metoda udostepnijaca widok.
     *
     * @return Wyrenderowany widok
     */
    @Override
    public ConfigDialog render() {
        return configDialogSimpleView.drawView();
    }
}
