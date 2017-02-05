package models;


import controller.interfaces.RecipientCtrlInterface;

public interface Message {
    /**
     * Udostepnia obiekt bedacy kontrolerem odbiorcy.
     *
     * @return Kontroler odbiorcy.
     */
    RecipientCtrlInterface getRecipient();

    /**
     * Umozliwia zmiane odbiorcy.
     *
     * @param recipiant Nowy odbiorca.
     */
    void setRecipiant(RecipientCtrlInterface recipiant);

    /**
     * Udostepnia zawartosc wiadomosci.
     *
     * @return Zawartosc wiadomosci.
     */
    String getContent();
}
