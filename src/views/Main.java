package views;

import controller.AgentCtrlInterface;
import controller.MessageBoxesCtrlInterface;

import javax.swing.*;
import java.awt.*;


public class Main extends JPanel implements SimpleView {

    //Controllers
    AgentCtrlInterface agentCtrl;



    MessageBoxesCtrlInterface messageBoxesCtrl;

    GridBagConstraints gbc;

    public Main(AgentCtrlInterface agentCtrl, MessageBoxesCtrlInterface messageBoxesCtrl) {
        this.agentCtrl = agentCtrl;
        this.messageBoxesCtrl = messageBoxesCtrl;
        this.gbc = new GridBagConstraints();
    }

    @Override
    public Main drawView() {
        gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        addComp(messageBoxesCtrl.render(), 0, 0, 1, 2,
                GridBagConstraints.BOTH, 0.8, 1.0);
        addComp(agentCtrl.render(), 1, 0, 1, 1,
                GridBagConstraints.BOTH, 0.2, 1.0);
        return this;
    }

    private void addComp(Component comp, int x, int y, int width, int height,
                         int fill, double weightx, double weighty) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.fill = fill;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        add(comp, gbc);
    }

    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
    }
}
