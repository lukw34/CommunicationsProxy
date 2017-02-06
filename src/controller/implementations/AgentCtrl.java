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
    private RecipientGroupCtrlInterface recipientGroupCtrl;

    private int messagesQuantiy = AppConfig.MAX_NUMBER_OF_MESSAGES;

    /**
     * Tworzy klase AgentCtrl
     *
     * @param initParams       Parametry poczatkowe.
     * @param recipientGroupCtrl Kontroler odpowiadajacy za zarzadzanie adresatami.
     */
    public AgentCtrl(InitParamsInterface initParams, RecipientGroupCtrlInterface recipientGroupCtrl) {
        this.initParams = initParams;
        this.recipientGroupCtrl = recipientGroupCtrl;
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
                RecipientCtrlInterface recipient = recipientGroupCtrl.getRandomRecipient();
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

    /**
     * Logika zwiazana z zwiekszeniem ilosci wiadomosci o 1.
     */
    @Override
    public void addMessage() {
        int numberOfMessages = initParams.getMessageQuantity();
        System.out.println(numberOfMessages);
        if(numberOfMessages < AppConfig.MAX_NUMBER_OF_MESSAGES) {
            numberOfMessages ++;
            MessageCtrlInterface setToActive = this.messageCtrls.get(numberOfMessages);
            RecipientCtrlInterface recipient = recipientGroupCtrl.getRandomRecipient();
            setToActive.setMessage(new SimpleMessage(recipient, "Message" + numberOfMessages));
            setToActive.setState(setToActive.getWaiting());
            initParams.setMessageQuantity(numberOfMessages);
        }
    }
}
