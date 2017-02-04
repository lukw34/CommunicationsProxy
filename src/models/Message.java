package models;


import controller.interfaces.BoxCtrlInterface;

public interface Message {
    BoxCtrlInterface getRecipient();

    void setRecipiant(BoxCtrlInterface recipiant);

    void decorateMessage(int magicNumber);

    String getContent();
}
