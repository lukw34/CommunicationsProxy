import config.AppConfig;
import controller.*;
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
    ViewController mainCtrl;
    AgentCtrlInterface agentCtrl;

    /**
     * Models
     */
    InitParamsInterface initParams;

    public Base() {
        super("Message");
        config();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension size = new Dimension(AppConfig.jFrameWidth, AppConfig.jFrameHeight);
        setSize(size);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void config() {
        //Dialog
        initParams = new InitialParams();
        dialogCtrl = new ConfigDialogCtrl(initParams, this);

        //Header
        headerCtrl = new AppHeaderCtrl(dialogCtrl);

        //Main
        mainCtrl = new MainCtrl(initParams);
    }

    public void render() {
        initElements();
        dialogCtrl.render();
        add(footer, BorderLayout.PAGE_END);
        add(headerCtrl.render(), BorderLayout.PAGE_START);
        add(mainCtrl.render(), BorderLayout.CENTER);
        setVisible(true);
        dialogCtrl.addSubscriber(mainCtrl);
        dialogCtrl.showDialog();
    }

    private void initElements() {
        footer = new JLabel("Autor: Łukasz Walewski (188584)");
    }
}

