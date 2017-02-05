package views;

import java.awt.*;

/**
 * Interfejs widoku aplikacji.
 *
 * @param <T> obiekt komponentu.
 */
public interface SimpleView<T extends Component> {
    /**
     * Udostepnienie metody rysujacej widok.
     *
     * @return Narysowany widok.
     */
    T drawView();

    /**
     * Udostepnienie metody zmieniajacej widocznosc komponentu.
     *
     * @param visible Flaga zwiazana z widoscznoscia.
     */
    void setVisible(boolean visible);

    /**
     * Odswiezenie widoku.
     */
    void repaint();
}
