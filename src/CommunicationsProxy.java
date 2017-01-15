import elements.Base;
import elements.ConfigDialog;

import javax.swing.*;
import java.awt.*;

public class CommunicationsProxy extends JFrame {
    private Base base;
    ConfigDialog dialog;

    public CommunicationsProxy() throws HeadlessException {
        super("communications Proxy");
        this.dialog = new ConfigDialog(this);
        this.base = new Base(this.dialog);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
    }

    public void render() {
        add(base.render());
        setVisible(true);
    }
}

