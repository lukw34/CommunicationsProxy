package elements;

import models.InitialParams;

import javax.swing.*;
import java.awt.*;

public class ConfigDialog extends JDialog {
    private final static String TITLE = "Confguration of simulator.";


    private JSpinner startNumberOfCommunicats;
    private JSpinner numberOFThreads;
    private JButton submitButton;

    private InitialParams initialParams;

    public ConfigDialog(JFrame base) {
        super(base, TITLE);
        initialParams = new InitialParams();

        Point point = new Point(400, 400);
        setLocation(point.x, point.y);
        initeElements();

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
    }

    private JPanel createSubmitPanel() {
        JPanel submitPanel = new JPanel();
        submitButton.addActionListener(event -> {
            initialParams.setConfiguration((Integer)startNumberOfCommunicats.getValue(),
                    (Integer)numberOFThreads.getValue());
            closeDialog();
            dispose();
        });
        submitPanel.add(submitButton);
        return submitPanel;
    }

    private void initeElements() {
        startNumberOfCommunicats = new JSpinner(new SpinnerNumberModel(0, 0, 30, 1));
        numberOFThreads = new JSpinner(new SpinnerNumberModel(1, 1, 30, 1));
        submitButton = new JButton("submit");
    }

    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(2, 2));
        formPanel.add(new JLabel("Liczba komunikatów: "));
        formPanel.add(startNumberOfCommunicats);
        formPanel.add(new JLabel("Liczba wątków: "));
        formPanel.add(numberOFThreads);
        return formPanel;
    }

    public void showDialog() {
        setVisible(true);
    }

    public void closeDialog() {
        setVisible(false);
    }
}
