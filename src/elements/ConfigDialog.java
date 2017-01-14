package elements;

import javax.swing.*;
import java.awt.*;

public class ConfigDialog extends JDialog {
    private final static String TITLE = "Confguration of simulator.";
    private final String ESCAPE  = "ESCAPE";

    private JSpinner startNumberOfCommunicats;
    private JSpinner numberOFThreads;
    private JButton submitButton;

    public ConfigDialog(JFrame base) {
        super(base, TITLE);
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
        showDialog();
    }

    private JPanel createSubmitPanel() {
        JPanel submitPanel = new JPanel();
        submitButton.addActionListener(event -> {
            closeDialog();
            dispose();
        });
        submitPanel.add(submitButton);
        return submitPanel;
    }

    private void initeElements() {
        startNumberOfCommunicats = new JSpinner();
        numberOFThreads = new JSpinner();
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
