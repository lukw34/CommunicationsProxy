package controller.implementations;

import controller.interfaces.AgentCtrlInterface;
import controller.interfaces.HeaderCtrlInterface;
import controller.interfaces.RecipientGroupCtrlInterface;
import models.InitParamsInterface;
import views.Main;
import views.SimpleView;


/**
 * Klasa reprezentujaca glowny kontroller aplikacji.
 */
public class MainCtrl extends BaseCtrl<Main> {
    //Dane
    private InitParamsInterface initParams;

    //Podpięty widok
    private SimpleView<Main> mainView;

    //Kontrollery
    private AgentCtrlInterface agentCtrl;
    private RecipientGroupCtrlInterface recipientGroupCtrl;
    private HeaderCtrlInterface headerCtrl;

    /**
     * Tworzy obiekt klasy MainCtrl
     *
     * @param initParams dane
     */
    public MainCtrl(InitParamsInterface initParams) {
        this.initParams = initParams;
        this.recipientGroupCtrl = new MessageRecipientsGroupCtrl(initParams);
        this.agentCtrl = new AgentCtrl(initParams, recipientGroupCtrl);
        this.headerCtrl = new AppHeaderCtrl(this.agentCtrl, this.recipientGroupCtrl);
        this.mainView = new Main(this.agentCtrl, this.recipientGroupCtrl, this.headerCtrl);

        new Thread((Runnable) this.agentCtrl).start();
    }

    /**
     * Metoda udostepnijaca widok.
     *
     * @return Wyrenderowany widok
     */
    @Override
    public Main render() {
        return mainView.drawView();
    }

    /**
     * Metoda reagująca na zamknięcie okna dialogowego.
     */
    @Override
    public void onSubmit() {
        recipientGroupCtrl.onParamsChange();
        agentCtrl.onParamsChange();
        agentCtrl.unlock();
    }
}

