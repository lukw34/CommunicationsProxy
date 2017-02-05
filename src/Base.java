import controller.implementations.AppHeaderCtrl;
import controller.implementations.BaseCtrl;
import controller.implementations.ConfigDialogCtrl;
import controller.implementations.MainCtrl;
import controller.interfaces.DialogCtrlInterface;
import controller.interfaces.HeaderCtrlInterface;
import models.InitParamsInterface;
import models.InitialParams;
import utils.AppConfig;

import javax.swing.*;
import java.awt.*;

/**
 * Klasa reprezentujaca glowne okno aplikacji
 */
public class Base extends JFrame {
    private JLabel footer;

    /**
     * Kontrolery
     */
    private DialogCtrlInterface dialogCtrl;
    private HeaderCtrlInterface headerCtrl;
    private BaseCtrl mainCtrl;

    /**
     * Models
     */
    private InitParamsInterface initParams;

    /**
     * Tworzy obiekt klasy Base(ramka).
     */
    public Base() {
        super("MessageWaiting");
        this.config();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension size = new Dimension(AppConfig.J_FRAME_WIDTH, AppConfig.J_FRAME_HEIGHT);
        this.setSize(size);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    /**
     * Metoda konfigurujaca aplikacje.
     */
    private void config() {
        //Dialog
        initParams = new InitialParams();
        dialogCtrl = new ConfigDialogCtrl(initParams, this);

        //Header
        headerCtrl = new AppHeaderCtrl();

        //Main
        mainCtrl = new MainCtrl(initParams);
    }

    /**
     * Metoda odpalajaca aplikacje.
     */
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

    /**
     * Metoda inicjalizujaca elementy.
     */
    private void initElements() {
        footer = new JLabel("Autor: Łukasz Walewski (188584)");
    }
}

