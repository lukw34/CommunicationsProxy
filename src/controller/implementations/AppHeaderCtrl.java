package controller.implementations;

import controller.interfaces.AgentCtrlInterface;
import controller.interfaces.HeaderCtrlInterface;
import controller.interfaces.RecipientGroupCtrlInterface;
import views.Header;
import views.SimpleView;

import java.awt.event.ActionEvent;

/**
 * Klasa bedaca kontrolerem naglowka.
 */
public class AppHeaderCtrl implements HeaderCtrlInterface<Header> {

    private SimpleView<Header> header;

    private AgentCtrlInterface agentCtrl;
    private RecipientGroupCtrlInterface recipientGroupCtrl;

    /**
     * Tworzy obiket klasy AppHeaderCtrl
     *
     * @param agentCtrl Kontroler posrednika.
     * @param recipientGroupCtrl Kontroler grupy odbiorcow(watkow)
     */
    public AppHeaderCtrl(AgentCtrlInterface agentCtrl, RecipientGroupCtrlInterface recipientGroupCtrl) {
        this.header = new Header(this);
        this.agentCtrl = agentCtrl;
        this.recipientGroupCtrl = recipientGroupCtrl;
    }

    /**
     * Metoda udostepnijaca widok.
     *
     * @return Wyrenderowany widok
     */
    @Override
    public Header render() {
        return this.header.drawView();
    }

    /**
     * Logika zwiazana z kliknieciem przycisku dodajacego watek.
     */
    @Override
    public void onAddThread(ActionEvent event) {
        this.recipientGroupCtrl.addThread();
    }
}
