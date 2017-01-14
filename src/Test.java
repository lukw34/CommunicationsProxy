import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        CommunicationsProxy communicationsProxy = new CommunicationsProxy();
        SwingUtilities.invokeLater(communicationsProxy::render);
    }
}
