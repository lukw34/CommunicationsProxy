import controller.AppHeaderCtrl;
import controller.ConfigDialogCtrl;
import controller.DialogCtrlInterface;
import controller.HeaderCtrl;
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
    HeaderCtrl headerCtrl;
    /**
     * Models
     */
    InitParamsInterface initParams;

    public Base() {
        super("Message");
        config();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
    }

    private void config() {
        //Dialog
        initParams = new InitialParams();
        dialogCtrl = new ConfigDialogCtrl(initParams, this);

        //Header
        headerCtrl = new AppHeaderCtrl(dialogCtrl);

    }

    public void render() {
        initElements();
        dialogCtrl.render();
        add(footer, BorderLayout.PAGE_END);
        add(headerCtrl.render(), BorderLayout.PAGE_START);
        setVisible(true);
    }

    private void initElements() {
        footer = new JLabel("Autor: Łukasz Walewski (188584)");
    }
}

