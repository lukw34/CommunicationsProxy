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

public class AgentCtrl implements AgentCtrlInterface<Agent>, Runnable {
    SimpleView<Agent> agentView;

    private InitParamsInterface initParams;
    private ArrayList<MessageCtrlInterface> messageCtrls;
    private ArrayList<MessageCtrlInterface> queue;

    private MessageBoxesCtrlInterface messageBoxesCtrl;

    private int messagesQuantiy = AppConfig.MAX_NUMBER_OF_MESSAGES;

    public AgentCtrl(InitParamsInterface initParams, MessageBoxesCtrlInterface messageBoxesCtrl) {
        this.initParams = initParams;
        this.agentView = new Agent(this);
        this.messageBoxesCtrl = messageBoxesCtrl;
        this.messageCtrls = new ArrayList<>();

        for (int messageIndex = 0; messageIndex < messagesQuantiy; messageIndex++) {
            messageCtrls.add(new MessageCtrl());
        }
    }

    @Override
    public Agent render() {
        return agentView.drawView();
    }

    @Override
    public Stream<Component> getMessages() {
        return messageCtrls.stream().map(MessageCtrlInterface::render);
    }

    @Override
    public void onParamsChange() {
        for (int index = 0; index < messagesQuantiy; index++) {
            MessageCtrlInterface message = messageCtrls.get(index);
            if (index < initParams.getMessageQuantity()) {
                message.setState(message.getWaiting());
                BoxCtrlInterface recipient = messageBoxesCtrl.getRandomRecipient();
                message.setMessage(new SimpleMessage(recipient, "Message" + index));
            } else {
                message.setState(message.getEmpty());
            }

            message.repaint();
        }
    }

    @Override
    public synchronized void unlock() {
        notify();
    }

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
