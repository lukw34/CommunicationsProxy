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

    private ArrayList<RecipientCtrlInterface> boxCtrls;

    /**
     * Tworzy obiekt klasy MessageRecipientsGroupCtrl.
     *
     * @param initParams Parametry inicjalzujace.
     */
    public MessageRecipientsGroupCtrl(InitParamsInterface initParams) {
        this.initParams = initParams;
        this.messageBoxesView = new RecipientGroup(this);
        this.boxCtrls = new ArrayList<>();

        for (int messageBoxIndex = 0; messageBoxIndex < this.messageBoxesQuantiy; messageBoxIndex++) {
            this.boxCtrls.add(new MessageRecipientCtrl("Thread" + messageBoxIndex, this));
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
        return this.boxCtrls.stream().map(RecipientCtrlInterface::render);
    }

    /**
     * Zwraca losowego (niepustego) odbiorce.
     *
     * @return Losowy odbiorca.
     */
    @Override
    public RecipientCtrlInterface getRandomRecipient() {
        int randomIndex = (int) (Math.random() * this.initParams.getNumberOfThreaads());
        return this.boxCtrls.get(randomIndex);
    }

    /**
     * Metoda realizujaca logike podczas zmiany parametrów.
     */
    @Override
    public void onParamsChange() {
        for (int index = 0; index < messageBoxesQuantiy; index++) {
            RecipientCtrlInterface box = boxCtrls.get(index);
            if (index < initParams.getNumberOfThreaads()) {
                box.setState(box.getReady());
            } else {
                box.setState(box.getEmpty());
            }
        }
    }
}
