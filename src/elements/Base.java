package elements;

import javax.swing.*;

public class Base extends JPanel {

    private ConfigDialog dialog;
    private GroupLayout layout;

    public Base(ConfigDialog dialog) {
        this.dialog = dialog;
    }


    public Base render() {
        dialog.showDialog();
        return this;
    }


}
