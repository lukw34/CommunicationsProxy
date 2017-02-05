package controller.interfaces;

import java.awt.*;

/**
 * Interfejs stanu odbiorcy. Każdy nowy stan powinien implementowac ten interfejs.
 */
public interface RecipientState {
    /**
     * Zapewnia mozliwosc rysowania adresata.
     *
     * @param g          Grafika.
     * @param startPoint Punkt poczatkowy.
     */
    void paint(Graphics g, Point startPoint);

    /**
     * Informuje w zaleznosci od stanu o gotowosci adresata.
     *
     * @return Informacje o gotowosci adresata.
     */
    boolean isReady();
}
