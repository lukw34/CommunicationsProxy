package views;

import utils.AppConfig;
import controller.interfaces.DialogCtrlInterface;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;

public class ConfigDialog extends JDialog implements SimpleView<ConfigDialog> {
    private final static String TITLE = "Confguration of simulator.";


    private JSpinner messageQuantity;
    private JSpinner numberOFThreads;
    private JButton submitButton;

    DialogCtrlInterface dialogCtrl;

    public ConfigDialog(JFrame base, DialogCtrlInterface dialogCtrl) {
        super(base, TITLE);
        this.dialogCtrl = dialogCtrl;
    }

    @Override
    public ConfigDialog drawView() {
        initElements();
        /**
         *  Dodanie formularza do okna dialogowego
         */
        JPanel formPanel = createFormPanel();
        getContentPane().add(formPanel);

        /**
         * Dodanie przycisku submit do okna dialogowego
         */
        JPanel submitPanel = createSubmitPanel();
        getContentPane().add(submitPanel, BorderLayout.PAGE_END);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        return this;
    }

    private void initElements() {
        messageQuantity = new JSpinner(new SpinnerNumberModel(1, 1, AppConfig.MAX_NUMBER_OF_MESSAGES, 1));
        numberOFThreads = new JSpinner(new SpinnerNumberModel(1, 1, AppConfig.MAX_NUMBER_OF_THREADS, 1));
        submitButton = new JButton("submit");
    }

    private JPanel createSubmitPanel() {
        JPanel submitPanel = new JPanel();
        submitButton.addActionListener(dialogCtrl::closeDialog);
        submitPanel.add(submitButton);
        return submitPanel;
    }

    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(2, 2));

        formPanel.add(new JLabel("Liczba komunikatów: "));
        messageQuantity.addChangeListener(this::onChangeMessageQuantity);
        formPanel.add(messageQuantity);

        formPanel.add(new JLabel("Liczba wątków: "));
        numberOFThreads.addChangeListener(this::onChangeNumberOfThreads);
        formPanel.add(numberOFThreads);
        return formPanel;
    }

    private void onChangeNumberOfThreads(ChangeEvent event) {
        dialogCtrl.changeNumberOfThreads(numberOFThreads.getValue());
    }

    private void onChangeMessageQuantity(ChangeEvent event) {
        dialogCtrl.changeMessageQuantity(messageQuantity.getValue());
    }
}


