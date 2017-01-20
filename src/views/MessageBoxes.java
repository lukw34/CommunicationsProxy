package views;

import components.EmptyBox;
import components.ReadyBox;
import controller.MessageBoxesCtrlInterface;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MessageBoxes extends JPanel implements SimpleView<MessageBoxes> {
    private Border border;

    private int messageBoxesQuantiy = 24;
    private MessageBoxesCtrlInterface messageBoxesCtrl;

    public MessageBoxes(MessageBoxesCtrlInterface mainCtrl) {
        this.messageBoxesCtrl = mainCtrl;
    }



    /**
     *
     * @return
     */
    @Override
    public MessageBoxes drawView() {
        initElements();
        setLayout(new GridLayout(8, 3));
        for (int messageBoxIndex = 0; messageBoxIndex < messageBoxesQuantiy; messageBoxIndex++) {
            if (messageBoxIndex < messageBoxesCtrl.getActivemessageBoxes()) {
                add(new ReadyBox(new Point(0, 0)));
            } else {
                add(new EmptyBox(new Point(0, 0)));
            }
        }
        setBorder(this.border);
        return this;
    }

    private void initElements() {}

    @Override
    public void repaint() {
        super.repaint();
    }
}
