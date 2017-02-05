package controller.implementations;

import controller.interfaces.AgentCtrlInterface;
import controller.interfaces.RecipientGroupCtrlInterface;
import models.InitParamsInterface;
import views.Main;
import views.SimpleView;


/**
 * Klasa reprezentujaca glowny kontroller aplikacji.
 */
public class MainCtrl extends BaseCtrl<Main> {
    //Dane
    InitParamsInterface initParams;

    //Podpięty widok
    SimpleView<Main> mainView;

    //Kontrollery
    AgentCtrlInterface agentCtrl;
    RecipientGroupCtrlInterface messageBoxesCtrl;

    /**
     * Tworzy obiekt klasy MainCtrl
     *
     * @param initParams dane
     */
    public MainCtrl(InitParamsInterface initParams) {
        this.initParams = initParams;
        this.messageBoxesCtrl = new MessageRecipientsGroupCtrl(initParams);
        this.agentCtrl = new AgentCtrl(initParams, messageBoxesCtrl);
        this.mainView = new Main(this.agentCtrl, this.messageBoxesCtrl);

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
        messageBoxesCtrl.onParamsChange();
        agentCtrl.onParamsChange();
        agentCtrl.unlock();
    }
}

