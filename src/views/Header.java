package views;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.ExecutionException;

/**
 * Klasa reprezentujaca widok naglowka.
 */
public class Header extends JPanel implements SimpleView<Header> {
    //Elementy
    private JButton reset;
    private JLabel title;
    private Border border;

    /**
     * Torzenie(rysowanie) widoku naglowka.
     *
     * @return Narysowany/gotowy widok.
     */
    @Override
    public Header drawView() {
        this.setLayout(new BorderLayout());
        this.initElements();

        this.add(title, BorderLayout.NORTH);
        this.setBorder(border);
        return this;
    }

    /**
     * Inicjalizuje elementy widoku.
     */
    private void initElements() {
        this.imageLoader.run();
        Border raisedbevel = BorderFactory.createRaisedBevelBorder();
        Border loweredbevel = BorderFactory.createLoweredBevelBorder();
        this.border = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
        this.title = new JLabel("Symulator pośrednika wiadomości.");
        this.title.setFont(new Font("Sans Serif", Font.BOLD, 20));
        this.title.setHorizontalAlignment(SwingConstants.CENTER);
    }

    /**
     * Metoda ladujaca obrazki.
     */
    private SwingWorker<Image, ImageIcon> imageLoader = new SwingWorker<Image, ImageIcon>() {

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
}
