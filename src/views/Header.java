package views;

import controller.interfaces.HeaderCtrlInterface;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.ExecutionException;

/**
 * Klasa reprezentujaca widok naglowka.
 */
public class Header extends JPanel implements SimpleView<Header> {
    //Elementy
    private JLabel title;
    private Border border;

    private HeaderCtrlInterface headerCtrl;

    /**
     * Tworzy obiekt klasy Header(widok).
     *
     * @param headerCtrl Kontroler widoku.
     */
    public Header(HeaderCtrlInterface headerCtrl) {
        this.headerCtrl = headerCtrl;
    }

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
        new ButtonsGroup("img/plus.png", BorderLayout.WEST, headerCtrl::onAddThread, null).run();
        new ButtonsGroup("img/minus.png", BorderLayout.EAST, null, null).run();

        loadLogo.run();
        Border raisedbevel = BorderFactory.createRaisedBevelBorder();
        Border loweredbevel = BorderFactory.createLoweredBevelBorder();
        this.border = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
        this.title = new JLabel("Symulator pośrednika wiadomości.");
        this.title.setFont(new Font("Sans Serif", Font.BOLD, 23));
        this.title.setHorizontalAlignment(SwingConstants.CENTER);
    }

    /**
     * Klasa ladujaca w tle przyciski sterujace aplikacja .
     */
    private class ButtonsGroup extends SwingWorker<Image, ImageIcon> {

        private String path;
        private String place;
        private ActionListener threadListener;
        private ActionListener messageLsitener;


        public ButtonsGroup(String path, String place,
                            ActionListener threadListener,
                            ActionListener messageLsitener) {
            this.path = path;
            this.place = place;
            this.threadListener = threadListener;
            this.messageLsitener = messageLsitener;
        }

        @Override
        protected Image doInBackground() throws Exception {
            BufferedImage picture = ImageIO.read(new File(this.path).toURI().toURL().openStream());
            return picture.getScaledInstance(30, 20, 2);
        }

        @Override
        protected void done() {
            try {
                JPanel buttons = new JPanel();
                buttons.setLayout(new GridLayout(2, 1));
                ImageIcon icon = new ImageIcon(get());
                JButton threadButton = new JButton("Watek", icon);
                JButton messageButton = new JButton("Wiadomosc", icon);
                threadButton.addActionListener(this.threadListener);
                buttons.add(threadButton);
                buttons.add(messageButton);
                add(buttons, place);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  Watek umozliwaaiajacy ladowanie loga w tle.
     */
    private SwingWorker<Image, ImageIcon> loadLogo = new SwingWorker<Image, ImageIcon>() {
        @Override
        protected Image doInBackground() throws Exception {
            BufferedImage picture = ImageIO.read(new File("img/logo.png").toURI().toURL().openStream());
            return picture.getScaledInstance(90, 80, 2);
        }

        @Override
        protected void done() {
            try {
                ImageIcon logo = new ImageIcon(get());
                JLabel logoLabel = new JLabel(logo);
                add(logoLabel, BorderLayout.CENTER);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    };
}
