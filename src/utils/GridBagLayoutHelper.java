package utils;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutHelper {

    /**
     *
     * @param panel Panel do którego zostanie doddany komponent.
     * @param comp Dodawany komponent
     * @param x
     * @param y
     * @param width
     * @param height
     * @param fill
     * @param weightx
     * @param weighty
     */
    public static void addComp(JPanel panel, Component comp, int x, int y, int width, int height,
                               int fill, double weightx, double weighty) {
        GridBagConstraints gbc = new GridBagConstraints();;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.fill = fill;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        panel.add(comp, gbc);
    }

}
