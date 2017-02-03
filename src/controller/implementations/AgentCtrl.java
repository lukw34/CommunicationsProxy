package controller.implementations;


import controller.interfaces.AgentCtrlInterface;
import controller.interfaces.DialogSubscriber;
import controller.interfaces.MessageCtrlInterface;
import models.InitParamsInterface;
import utils.AppConfig;
import views.Agent;
import views.SimpleView;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

public class AgentCtrl implements AgentCtrlInterface<Agent>, DialogSubscriber, Runnable {
    SimpleView<Agent> agentView;

    private InitParamsInterface initParams;
    private ArrayList<MessageCtrlInterface> messageCtrls;
    private ArrayList<MessageCtrlInterface> queue;

    private int messagesQuantiy = AppConfig.MAX_NUMBER_OF_MESSAGES;

    private ReentrantLock reentrantLock;

    public AgentCtrl(InitParamsInterface initParams) {
        this.initParams = initParams;
        this.reentrantLock = new ReentrantLock();
        agentView = new Agent(this);
        messageCtrls = new ArrayList<>();

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
                message.setState(message.getMessage());
            } else {
                message.setState(message.getEmpty());
            }

            message.repaint();
        }
    }

    @Override
    public synchronized void  unlock() {
        notify();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (initParams.getMessageQuantity() < 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                for (int messageBoxIndex = 0; messageBoxIndex < initParams.getMessageQuantity(); messageBoxIndex++) {
                    try {
                        Thread.sleep(250);
                        MessageCtrlInterface message = messageCtrls.get(messageBoxIndex);
                        message.sendIfPossible();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
