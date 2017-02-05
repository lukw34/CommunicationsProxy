import javax.swing.*;

/**
 * Klasa głowna odpalajaca aplikacje.
 */
public class App {

    /**
     * Punkt startowy aplikacji.
     *
     * @param args
     */
    public static void main(String[] args) {
        Base base = new Base();
        SwingUtilities.invokeLater(base::render);
    }
}
