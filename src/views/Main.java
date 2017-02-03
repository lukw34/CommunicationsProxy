package views;

import controller.interfaces.AgentCtrlInterface;
import controller.interfaces.MessageBoxesCtrlInterface;
import utils.GridBagLayoutHelper;

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
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    public Main drawView() {
        gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        GridBagLayoutHelper.addComp(this, messageBoxesCtrl.render(), 0, 0, 1, 2,
                GridBagConstraints.BOTH, 0.6, 1.0);
        GridBagLayoutHelper.addComp(this, agentCtrl.render(), 1, 0, 1, 1,
                GridBagConstraints.BOTH, 0.4, 1.0);
        return this;
    }

    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
    }
}
