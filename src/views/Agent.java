package views;

import controller.AgentCtrlInterface;

import javax.swing.*;

public class Agent  extends JPanel implements SimpleView<Agent> {
    private AgentCtrlInterface agentCtrl;

    public Agent(AgentCtrlInterface agentCtrl) {
        this.agentCtrl = agentCtrl;
    }

    @Override
    public Agent drawView() {
        add(new JLabel("Kolejka wiadomości"));
        return this;
    }

    @Override
    public void setVisible(boolean isVisible) {

    }
}
