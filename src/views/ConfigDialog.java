package views;

import controller.DialogCtrlInterface;

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
    public ConfigDialog render() {
        initElements();

        /**
         *  Add form panel to JDialog
         */
        JPanel formPanel = createFormPanel();
        getContentPane().add(formPanel);

        /**
         * Add button panel to JDialog
         */
        JPanel submitPanel = createSubmitPanel();
        getContentPane().add(submitPanel, BorderLayout.PAGE_END);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        return this;
    }

    private void initElements() {
        messageQuantity = new JSpinner(new SpinnerNumberModel(0, 0, 30, 1));
        numberOFThreads = new JSpinner(new SpinnerNumberModel(1, 1, 30, 1));
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


