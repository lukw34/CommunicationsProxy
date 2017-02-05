package controller.implementations;

import controller.interfaces.*;
import models.InitParamsInterface;
import models.SimpleMessage;
import utils.AppConfig;
import views.Agent;
import views.SimpleView;

import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Klasa bedaca implementacja posrednika jako kontrolwera widoku i watku.
 */
public class AgentCtrl implements AgentCtrlInterface<Agent>, Runnable {
    private SimpleView<Agent> agentView;

    private InitParamsInterface initParams;

    private ArrayList<MessageCtrlInterface> messageCtrls;
    private RecipientGroupCtrlInterface messageBoxesCtrl;

    private int messagesQuantiy = AppConfig.MAX_NUMBER_OF_MESSAGES;

    /**
     * Tworzy klase AgentCtrl
     *
     * @param initParams       Parametry poczatkowe.
     * @param messageBoxesCtrl Kontroler odpowiadajacy za zarzadzanie adresatami.
     */
    public AgentCtrl(InitParamsInterface initParams, RecipientGroupCtrlInterface messageBoxesCtrl) {
        this.initParams = initParams;
        this.messageBoxesCtrl = messageBoxesCtrl;
        this.agentView = new Agent(this);
        this.messageCtrls = new ArrayList<>();

        /**
         * Inicjalizacja wiadomosci.
         */
        for (int messageIndex = 0; messageIndex < this.messagesQuantiy; messageIndex++) {
            this.messageCtrls.add(new MessageCtrl());
        }
    }

    /**
     * Zwraca widok posrednika, ktory jest gotowy do wyswietlenia.
     *
     * @return Widok posrednika.
     */
    @Override
    public Agent render() {
        return this.agentView.drawView();
    }

    /**
     * Generuje liste wiadomosci do wyswietlania.
     *
     * @return Strumien widokow wiadomosci.
     */
    @Override
    public Stream<Component> getMessages() {
        return this.messageCtrls.stream().map(MessageCtrlInterface::render);
    }

    /**
     * Metoda realizujaca logike podczas zmiany parametrów.
     */
    @Override
    public void onParamsChange() {
        for (int index = 0; index < messagesQuantiy; index++) {
            MessageCtrlInterface message = messageCtrls.get(index);
            if (index < initParams.getMessageQuantity()) {
                message.setState(message.getWaiting());
                RecipientCtrlInterface recipient = messageBoxesCtrl.getRandomRecipient();
                message.setMessage(new SimpleMessage(recipient, "Message" + index));
            } else {
                message.setState(message.getEmpty());
            }

            message.repaint();
        }
    }

    /**
     * Odblokowuje watek.
     */
    @Override
    public synchronized void unlock() {
        notify();
    }

    /**
     * Implementacja watku.
     */
    @Override
    public void run() {
        try {
            synchronized (this) {
                wait();
            }

            while (true) {

                for (int messageBoxIndex = 0; messageBoxIndex < initParams.getMessageQuantity(); messageBoxIndex++) {
                    MessageCtrlInterface message = messageCtrls.get(messageBoxIndex);
                    message.sendIfPossible();
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
