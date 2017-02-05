package views;

import controller.interfaces.AgentCtrlInterface;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Klasa reprezentujaca widok posrednika.
 */
public class Agent extends JPanel implements SimpleView<Agent> {
    //Elementy
    private Border border;

    //Kontroler
    private AgentCtrlInterface agentCtrl;

    /**
     * Tworzy obiekt klasy Agent(widok).
     *
     * @param agentCtrl Kontroler widoku posrednika.
     */
    public Agent(AgentCtrlInterface agentCtrl) {
        this.agentCtrl = agentCtrl;
    }

    /**
     * Torzenie(rysowanie) widoku posrednika.
     *
     * @return Narysowany/gotowy widok.
     */
    @Override
    public Agent drawView() {
        this.initElements();
        this.setBorder(this.border);
        this.setLayout(new GridLayout(10, 9));
        this.agentCtrl.getMessages().forEach(message -> this.add((JPanel) message));
        return this;
    }

    /**
     * Inicjalizuje elementy widoku.
     */
    private void initElements() {
        this.border = new TitledBorder("Kolejka wiadomości");
    }
}
