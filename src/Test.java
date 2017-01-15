import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        Base base = new Base();
        SwingUtilities.invokeLater(base::render);
    }
}
