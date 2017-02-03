package views;

import controller.interfaces.BoxCtrlInterface;
import controller.interfaces.MessageBoxesCtrlInterface;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class MessageBoxes extends JPanel implements SimpleView<MessageBoxes> {
    private Border border;

    private int messageBoxesQuantiy = 24;
    private MessageBoxesCtrlInterface messageBoxesCtrl;

    private ArrayList<BoxCtrlInterface> boxCtrls;

    public MessageBoxes(MessageBoxesCtrlInterface messageBoxesCtrl) {
        this.boxCtrls = new ArrayList<>();
        this.messageBoxesCtrl = messageBoxesCtrl;
    }


    /**
     * @return
     */
    @Override
    public MessageBoxes drawView() {
        setLayout(new GridLayout(8, 3));
        messageBoxesCtrl.getMessageBoxes().forEach(box -> this.add((JPanel)box));
        setBorder(this.border);
        setVisible(true);
        return this;
    }
}
