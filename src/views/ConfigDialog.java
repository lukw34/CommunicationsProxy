package views;

import utils.AppConfig;
import controller.interfaces.DialogCtrlInterface;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;

/**
 * Klasa reprezentujaca widok okna dialogowego.
 */
public class ConfigDialog extends JDialog implements SimpleView<ConfigDialog> {
    private final static String TITLE = "Confguration of simulator.";

    //Elementy
    private JSpinner messageQuantity;
    private JSpinner numberOFThreads;
    private JButton submitButton;

    //Kontroler
    private DialogCtrlInterface dialogCtrl;

    public ConfigDialog(JFrame base, DialogCtrlInterface dialogCtrl) {
        super(base, TITLE);
        this.dialogCtrl = dialogCtrl;
    }

    /**
     * Torzenie(rysowanie) widoku okna dialogowego.
     *
     * @return Narysowany/gotowy widok.
     */
    @Override
    public ConfigDialog drawView() {
        this.initElements();
        /**
         *  Dodanie formularza do okna dialogowego
         */
        JPanel formPanel = createFormPanel();
        this.getContentPane().add(formPanel);

        /**
         * Dodanie przycisku submit do okna dialogowego
         */
        JPanel submitPanel = createSubmitPanel();
        this.getContentPane().add(submitPanel, BorderLayout.PAGE_END);

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setSize(400, 150);
        this.setLocationRelativeTo(null);

        return this;
    }

    /**
     * Inicjalizuje elementy widoku.
     */
    private void initElements() {
        this.messageQuantity = new JSpinner(new SpinnerNumberModel(1, 1, AppConfig.MAX_NUMBER_OF_MESSAGES, 1));
        this.numberOFThreads = new JSpinner(new SpinnerNumberModel(1, 1, AppConfig.MAX_NUMBER_OF_THREADS, 1));
        this.submitButton = new JButton("submit");
    }

    /**
     * Tworzenie przycisku potwierdzenia.
     *
     * @return Panel zawierajacy przycisk potwierdzenia.
     */
    private JPanel createSubmitPanel() {
        JPanel submitPanel = new JPanel();
        this.submitButton.addActionListener(this.dialogCtrl::closeDialog);
        submitPanel.add(this.submitButton);
        return submitPanel;
    }

    /**
     * Tworzenie formularza.
     *
     * @return Panel zawierajacy formularz z danymi.
     */
    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(2, 2));

        formPanel.add(new JLabel("Liczba komunikatów: "));
        this.messageQuantity.addChangeListener(this::onChangeMessageQuantity);
        formPanel.add(this.messageQuantity);

        formPanel.add(new JLabel("Liczba wątków: "));
        this.numberOFThreads.addChangeListener(this::onChangeNumberOfThreads);
        formPanel.add(this.numberOFThreads);
        return formPanel;
    }

    /**
     * Reakcja na zmiane liczby watkow.
     *
     * @param event Akcja zmiany wartosci.
     */
    private void onChangeNumberOfThreads(ChangeEvent event) {
        this.dialogCtrl.changeNumberOfThreads(this.numberOFThreads.getValue());
    }

    /**
     * Reakcja na zmiane liczby watkow.
     *
     * @param event Akcja zmiany wartosci.
     */
    private void onChangeMessageQuantity(ChangeEvent event) {
        this.dialogCtrl.changeMessageQuantity(this.messageQuantity.getValue());
    }
}


