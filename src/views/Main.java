package views;

import controller.interfaces.AgentCtrlInterface;
import controller.interfaces.HeaderCtrlInterface;
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
    private HeaderCtrlInterface headerCtrl;

    /**
     * Tworzenie klasy Main(widok)
     *
     * @param agentCtrl          Kontroler posrednika
     * @param recipientGroupCtrl Kontroler grupy odbiorcow.
     * @param headerCtrl         Kontroler naglowka.
     */
    public Main(AgentCtrlInterface agentCtrl,
                RecipientGroupCtrlInterface recipientGroupCtrl,
                HeaderCtrlInterface headerCtrl) {
        this.agentCtrl = agentCtrl;
        this.recipientGroupCtrl = recipientGroupCtrl;
        this.headerCtrl = headerCtrl;
    }

    /**
     * Torzenie(rysowanie) glownego widoku.
     *
     * @return Narysowany/gotowy widok.
     */
    @Override
    public Main drawView() {
        this.setLayout(new GridBagLayout());
        GridBagLayoutHelper.addComp(this, headerCtrl.render(), 0, 0, 0, 1,
                GridBagConstraints.BOTH, 1.0, 0.1);
        GridBagLayoutHelper.addComp(this, recipientGroupCtrl.render(), 0, 1, 1, 2,
                GridBagConstraints.BOTH, 0.6, 0.9);
        GridBagLayoutHelper.addComp(this, agentCtrl.render(), 1, 1, 1, 1,
                GridBagConstraints.BOTH, 0.4, 0.9);
        return this;
    }
}
