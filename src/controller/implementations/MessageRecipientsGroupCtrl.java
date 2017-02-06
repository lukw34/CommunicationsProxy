package controller.implementations;

import controller.interfaces.RecipientCtrlInterface;
import controller.interfaces.RecipientGroupCtrlInterface;
import models.InitParamsInterface;
import utils.AppConfig;
import views.RecipientGroup;
import views.SimpleView;

import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Klasa implementujaca kontroler grupy adresatow.
 */
public class MessageRecipientsGroupCtrl implements RecipientGroupCtrlInterface<RecipientGroup> {

    private SimpleView<RecipientGroup> messageBoxesView;
    private InitParamsInterface initParams;
    private int messageBoxesQuantiy = AppConfig.MAX_NUMBER_OF_THREADS;

    private ArrayList<RecipientCtrlInterface> recipientCtrls;

    /**
     * Tworzy obiekt klasy MessageRecipientsGroupCtrl.
     *
     * @param initParams Parametry inicjalzujace.
     */
    public MessageRecipientsGroupCtrl(InitParamsInterface initParams) {
        this.initParams = initParams;
        this.messageBoxesView = new RecipientGroup(this);
        this.recipientCtrls = new ArrayList<>();

        for (int messageBoxIndex = 0; messageBoxIndex < this.messageBoxesQuantiy; messageBoxIndex++) {
            this.recipientCtrls.add(new MessageRecipientCtrl("Thread" + messageBoxIndex, this));
        }
    }

    /**
     * Metoda udostepnijaca widok.
     *
     * @return Wyrenderowany widok
     */
    @Override
    public RecipientGroup render() {
        return this.messageBoxesView.drawView();
    }

    /**
     * Generuje liste adresatow do wyswietlania.
     *
     * @return Strumien widokow adresatow.
     */
    @Override
    public Stream<Component> getRecipients() {
        return this.recipientCtrls.stream().map(RecipientCtrlInterface::render);
    }

    /**
     * Zwraca losowego (niepustego) odbiorce.
     *
     * @return Losowy odbiorca.
     */
    @Override
    public RecipientCtrlInterface getRandomRecipient() {
        int randomIndex = (int) (Math.random() * this.initParams.getNumberOfThreaads());
        return this.recipientCtrls.get(randomIndex);
    }

    /**
     * Metoda realizujaca logike podczas zmiany parametrów.
     */
    @Override
    public void onParamsChange() {
        for (int index = 0; index < messageBoxesQuantiy; index++) {
            RecipientCtrlInterface box = recipientCtrls.get(index);
            if (index < initParams.getNumberOfThreaads()) {
                box.setState(box.getReady());
            } else {
                box.setState(box.getEmpty());
            }
        }
    }

    /**
     * Logika zwiazana z zwiekszeniem ilosci watkow o 1.
     */
    @Override
    public void addThread() {
        int numberOfThreads = initParams.getNumberOfThreaads();
        if(numberOfThreads < AppConfig.MAX_NUMBER_OF_THREADS) {
            RecipientCtrlInterface setToActive = this.recipientCtrls.get(numberOfThreads);
            setToActive.setState(setToActive.getReady());
            initParams.setNumberOfThreaads(numberOfThreads + 1);
        }
    }
}
