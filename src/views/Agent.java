package views;

import controller.interfaces.AgentCtrlInterface;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Agent extends JPanel implements SimpleView<Agent> {
    private AgentCtrlInterface agentCtrl;

    private Border border;

    public Agent(AgentCtrlInterface agentCtrl) {
        this.agentCtrl = agentCtrl;
    }

    @Override
    public Agent drawView() {
        initElements();
        setBorder(this.border);
        setLayout(new GridLayout(10, 9));
        agentCtrl.getMessages().forEach(message -> this.add((JPanel)message));
        return this;
    }

    private void initElements() {
        border = new TitledBorder("Kolejka wiadomości");

    }

    @Override
    public void setVisible(boolean isVisible) {

    }
}
