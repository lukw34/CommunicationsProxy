package controller;

import models.InitParamsInterface;
import views.ConfigDialog;
import views.SimpleView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigDialogCtrl implements DialogCtrlInterface<Integer, ConfigDialog> {

    SimpleView configDialogSimpleView;
    InitParamsInterface initParams;


    public ConfigDialogCtrl(InitParamsInterface initParams, JFrame parent) {
        this.initParams = initParams;
        this.configDialogSimpleView = new ConfigDialog(parent, this);

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
        configDialogSimpleView.setVisible(false);
    }

    @Override
    public ConfigDialog render() {
        return (ConfigDialog) configDialogSimpleView.drawView();
    }
}
