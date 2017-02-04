package models;

import controller.interfaces.BoxCtrlInterface;

/**
 * Klasa reorezentujaca prosta implementacje interfejsu Message reprezentujacy model danych.
 */
public class SimpleMessage implements Message {
    private BoxCtrlInterface recipient;
    private String content;

    /**
     * Tworzy obiekt klasy SimpleMessage.
     *
     * @param recipient Odbiorca wiadomosci.
     * @param content Zawartosc wiadomosci.
     */
    public SimpleMessage(BoxCtrlInterface recipient, String content) {
        this.recipient = recipient;
        this.content = content;
    }

    @Override
    public BoxCtrlInterface getRecipient() {
        return recipient;
    }

    /**
     * Metoda ustawiajaca odbiorce.
     *
     * @param recipient Nowy odbiorca wiadomosci.
     */
    @Override
    public void setRecipiant(BoxCtrlInterface recipient) {
        this.recipient = recipient;
    }

    /**
     * Metoda odpowiedzialna za przetworzenie wiadomości.
     *
     * @param magicNumber Losowa liczba.
     */
    @Override
    public void decorateMessage(int magicNumber) {
        System.out.println(magicNumber);
    }

    /**
     * Metoda pobierajaca zawartosc wiadomosci.
     *
     * @return Zawartość wiadomości.
     */
    @Override
    public String getContent() {
        return content;
    }
}
