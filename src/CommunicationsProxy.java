import elements.Base;
import elements.ConfigDialog;

import javax.swing.*;
import java.awt.*;

public class CommunicationsProxy extends JFrame {
    public CommunicationsProxy() throws HeadlessException {
        super("communications Proxy");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
    }

    public void render() {
        ConfigDialog dialog = new ConfigDialog(this);
        add(new Base(dialog));
        setVisible(true);
    }
}

