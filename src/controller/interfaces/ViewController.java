package controller.interfaces;

import java.awt.*;

/**
 * Interfejs reprezentujący kontroller odpowiedzialny za logikę widokow.
 *
 * @param <T> Widok jaki zostanie podpiœty do kontrollera.
 */
public interface ViewController<T extends Component> {
    /**
     * Zapewnia wyrenderowanie widoku.
     *
     * @return Gotowy widok.
     */
    T render();
}
