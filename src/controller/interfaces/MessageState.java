package controller.interfaces;

import java.awt.*;

/**
 * Interfejs stanu wiadomosci. Każdy nowy stan powinien implementowac ten interfejs.
 */
public interface MessageState {
    /**
     * Zapewnia mozliwosc rysowania wiadomosci wa zaleznosci od stanu.
     *
     * @param g          Grafika.
     * @param startPoint Punkt poczatkowy.
     */
    void paint(Graphics g, Point startPoint);

    /**
     * Informuje w zaleznosci od stanu o mozliwosci wyslania wiadomosci.
     *
     * @return Informacje o mozliwosci wyslania wiadomosci.
     */
    boolean canProcessing();
}
