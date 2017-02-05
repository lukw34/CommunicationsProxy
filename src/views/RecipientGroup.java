package views;

import controller.interfaces.RecipientGroupCtrlInterface;

import javax.swing.*;
import java.awt.*;

/**
 * Klasa reprezentujaca widok grupy odbiorcow.
 */
public class RecipientGroup extends JPanel implements SimpleView<RecipientGroup> {
    //Kontroler
    private RecipientGroupCtrlInterface recipientGroupCtrl;

    /**
     * Tworzy obiekt klasy RecipientGroup(widok).
     *
     * @param recipientGroupCtrl Kontroler widoku posrednika.
     */
    public RecipientGroup(RecipientGroupCtrlInterface recipientGroupCtrl) {
        this.recipientGroupCtrl = recipientGroupCtrl;
    }

    /**
     * Torzenie(rysowanie) widoku grupy odbiorcow.
     *
     * @return Narysowany/gotowy widok.
     */
    @Override
    public RecipientGroup drawView() {
        this.setLayout(new GridLayout(8, 3));
        this.recipientGroupCtrl.getRecipients().forEach(box -> this.add((JPanel) box));
        this.setVisible(true);
        return this;
    }
}
