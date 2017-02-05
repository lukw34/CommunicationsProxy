package views;

import controller.interfaces.AgentCtrlInterface;
import controller.interfaces.RecipientGroupCtrlInterface;
import utils.GridBagLayoutHelper;

import javax.swing.*;
import java.awt.*;

/**
 * Klasa reprezentujaca glowny widok.
 */
public class Main extends JPanel implements SimpleView<Main> {

    //Kontrolery
    private AgentCtrlInterface agentCtrl;
    private RecipientGroupCtrlInterface recipientGroupCtrl;

    /**
     * Tworzenie klasy Main(widok)
     *
     * @param agentCtrl Kontroler posrednika
     * @param recipientGroupCtrl Kontroler grupy odbiorcow.
     */
    public Main(AgentCtrlInterface agentCtrl, RecipientGroupCtrlInterface recipientGroupCtrl) {
        this.agentCtrl = agentCtrl;
        this.recipientGroupCtrl = recipientGroupCtrl;
    }

    /**
     * Torzenie(rysowanie) glownego widoku.
     *
     * @return Narysowany/gotowy widok.
     */
    @Override
    public Main drawView() {
        this.setLayout(new GridBagLayout());

        GridBagLayoutHelper.addComp(this, recipientGroupCtrl.render(), 0, 0, 1, 2,
                GridBagConstraints.BOTH, 0.6, 1.0);
        GridBagLayoutHelper.addComp(this, agentCtrl.render(), 1, 0, 1, 1,
                GridBagConstraints.BOTH, 0.4, 1.0);
        return this;
    }
}
