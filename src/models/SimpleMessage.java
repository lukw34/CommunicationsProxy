package models;

import controller.interfaces.RecipientCtrlInterface;

/**
 * Klasa reorezentujaca prosta implementacje interfejsu Message reprezentujacy model danych.
 */
public class SimpleMessage implements Message {
    private RecipientCtrlInterface recipient;
    private String content;

    /**
     * Tworzy obiekt klasy SimpleMessage.
     *
     * @param recipient Odbiorca wiadomosci.
     * @param content   Zawartosc wiadomosci.
     */
    public SimpleMessage(RecipientCtrlInterface recipient, String content) {
        this.recipient = recipient;
        this.content = content;
    }

    @Override
    public RecipientCtrlInterface getRecipient() {
        return this.recipient;
    }

    /**
     * Metoda ustawiajaca odbiorce.
     *
     * @param recipient Nowy odbiorca wiadomosci.
     */
    @Override
    public void setRecipiant(RecipientCtrlInterface recipient) {
        this.recipient = recipient;
    }

    /**
     * Metoda ustawiajaca tresc.
     *
     * @param content Nowa tresc wiadomosci.
     */
    @Override
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Metoda pobierajaca zawartosc wiadomosci.
     *
     * @return Zawartość wiadomości.
     */
    @Override
    public String getContent() {
        return this.content;
    }
}
