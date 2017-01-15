import controller.ConfigDialogCtrl;
import controller.DialogCtrlInterface;
import models.InitParamsInterface;
import models.InitialParams;

import javax.swing.*;
import java.awt.*;

public class Base extends JFrame {
    private JLabel footer;

    /**
     * Controllers
     */
    DialogCtrlInterface dialogCtrl;

    /**
     * Models
     */
    InitParamsInterface initParams;

    public Base() {
        super("Message");
        config();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    private void config() {
        //Dialog
        initParams = new InitialParams();
        dialogCtrl = new ConfigDialogCtrl(initParams, this);
        dialogCtrl.showDialog();

    }

    public void render() {
        initElements();
        add(footer, BorderLayout.PAGE_END);
        setVisible(true);
    }

    private void initElements() {
        footer = new JLabel("Autor: Łukasz Walewski (188584)");
    }
}

