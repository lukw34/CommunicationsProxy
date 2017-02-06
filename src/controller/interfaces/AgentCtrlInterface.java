package controller.interfaces;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Stream;

/**
 * Interfejs reprezentujący kontroller odpowiedzialny za logikę pośrednika.
 *
 * @param <T> Widok jaki zostanie podpiœty do kontrollera.
 */
public interface AgentCtrlInterface<T extends JPanel> extends ViewController<T> {
    /**
     *
     * @return Strumień zawierający wiadomości.
     */
    Stream<Component> getMessages();

    /**
     * Reakcja na zmianę parametrów.
     */
    void onParamsChange();

    /**
     * Metoda odblokowująca wątek pośrednika.
     */
    void unlock();
    /**
     * Dodanie wiadomosci.
     */
    void addMessage();
}
