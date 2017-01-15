package views;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.ExecutionException;


public class Header extends JPanel implements SimpleView<Header> {
    private JButton reset;
    private JLabel title;
    private Border border;

    @Override
    public Header drawView() {
        setLayout(new BorderLayout());
        initElements();

        add(title, BorderLayout.NORTH);
        setBorder(border);
        return this;
    }


    private void initElements() {
        loadReset.run();
        Border raisedbevel = BorderFactory.createRaisedBevelBorder();
        Border loweredbevel = BorderFactory.createLoweredBevelBorder();
       this.border = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
        title = new JLabel("Symulator pośrednika wiadomości.");
        title.setFont(new Font("Sans Serif", Font.BOLD, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private SwingWorker<Image, ImageIcon> loadReset = new SwingWorker<Image, ImageIcon>() {

        @Override
        protected Image doInBackground() throws Exception {
            BufferedImage picture = ImageIO.read(new File("img/reset.png").toURI().toURL().openStream());
            return picture.getScaledInstance(30, 20, 2);
        }

        @Override
        protected void done() {
            try {
                ImageIcon resetIcon = new ImageIcon(get());
                reset = new JButton("Kliknij, aby ustawić nową konfigurację.", resetIcon);
                add(reset, BorderLayout.CENTER);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    public void setVisible(boolean isVisible) {

    }
}
