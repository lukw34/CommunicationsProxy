package models;

/**
 * Model reprezentujacy dane inicjalizujace.
 */
public class InitialParams implements InitParamsInterface {
    private int numberOfThreaads;
    private int messageQuantity;

    /**
     * Tworzy obiekt klasy InitialParams. Ustawia rownież wartosci domyslne.
     */
    public InitialParams() {
        this.numberOfThreaads = 1;
        this.messageQuantity = 1;
    }

    /**
     * Udostepnia ilosc poczatkowych wiadomosci.
     *
     * @return Ilosc poczatkowych wiadomosci.
     */
    @Override
    public int getMessageQuantity() {
        return this.messageQuantity;
    }

    /**
     * Udostepnia ilosc watkow(adresatow).
     *
     * @return Ilosc watkow.
     */
    @Override
    public int getNumberOfThreaads() {
        return this.numberOfThreaads;
    }

    /**
     * Aktualizuje liczbie watkow.
     *
     * @param numberOfThreaads Liczba watkow (adresatow).
     */
    @Override
    public void setNumberOfThreaads(int numberOfThreaads) {
        this.numberOfThreaads = numberOfThreaads;
    }

    /**
     * Aktualizuje liczbe wiadomosci.
     *
     * @param messageQuantity Liczba wiadomosci..
     */
    @Override
    public void setMessageQuantity(int messageQuantity) {
        this.messageQuantity = messageQuantity;
    }
}
