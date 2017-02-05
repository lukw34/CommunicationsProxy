package controller.implementations;

import controller.interfaces.DialogCtrlInterface;
import controller.interfaces.DialogSubscriber;
import models.InitParamsInterface;
import views.ConfigDialog;
import views.SimpleView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Klasa implementujaca kontroler okna dialgowego(konfiguracyjnego)
 */
public class ConfigDialogCtrl implements DialogCtrlInterface<Integer, ConfigDialog> {

    private SimpleView<ConfigDialog> configDialogSimpleView;
    private InitParamsInterface initParams;

    private ArrayList<DialogSubscriber> subscribers;

    /**
     * Tworzy klase ConfigDialogCtrl
     *
     * @param initParams Parametry inicjalizujace.
     * @param parent     Nadrzedny JFrame.
     */
    public ConfigDialogCtrl(InitParamsInterface initParams, JFrame parent) {
        this.initParams = initParams;
        this.configDialogSimpleView = new ConfigDialog(parent, this);
        this.subscribers = new ArrayList<>();
    }

    /**
     * Metoda wyswietlajaca okno dialogowe.
     */
    @Override
    public void showDialog() {
        configDialogSimpleView.setVisible(true);
    }

    /**
     * Metoda reagujace na zmiane ilosci wiadomosci.
     *
     * @param numberOfMessages Nowa wartosc.
     */
    @Override
    public void changeMessageQuantity(Integer numberOfMessages) {
        this.initParams.setMessageQuantity(numberOfMessages);
    }

    /**
     * Metoda reagujace na zmiane ilosci watkow(adresatow).
     *
     * @param numberOfThreads Nowa wartosc.
     */
    @Override
    public void changeNumberOfThreads(Integer numberOfThreads) {
        this.initParams.setNumberOfThreaads(numberOfThreads);
    }

    /**
     * Metoda zajmujaca sie logika zwiazana z zamknieciem ogna dialogowym.
     * Powiadamia wszystkich zdefiniowanych interesariuszy.
     *
     * @param event Akcja zamkniecia okna dialogowego.
     */
    @Override
    public void closeDialog(ActionEvent event) {
        this.subscribers.forEach(DialogSubscriber::onSubmit);
        this.configDialogSimpleView.setVisible(false);
    }

    /**
     * Dodaje kontrollery, które zosta poinformowane, gdy okno dialogowe zostanie zamkniete.
     *
     * @param viewController Kontroler korzystajacy z danych podawanych w oknie dialogowym
     */
    @Override
    public void addSubscriber(DialogSubscriber viewController) {
        this.subscribers.add(viewController);
    }

    /**
     * Metoda udostepnijaca widok.
     *
     * @return Wyrenderowany widok
     */
    @Override
    public ConfigDialog render() {
        return this.configDialogSimpleView.drawView();
    }
}
