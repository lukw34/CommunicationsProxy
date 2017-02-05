package models;

/**
 * interfejs danych inicializujacych.
 */
public interface InitParamsInterface {
    /**
     * Udostepnia ilosc poczatkowych wiadomosci.
     *
     * @return Ilosc poczatkowych wiadomosci.
     */
    int getMessageQuantity();

    /**
     * Udostepnia ilosc watkow(adresatow).
     *
     * @return Ilosc watkow.
     */
    int getNumberOfThreaads();

    /**
     * Aktualizuje liczbe wiadomosci.
     *
     * @param messageQuantity Liczba wiadomosci..
     */
    void setMessageQuantity(int messageQuantity);

    /**
     * Aktualizuje liczbie watkow.
     *
     * @param numberOfThreaads Liczba watkow (adresatow).
     */
    void setNumberOfThreaads(int numberOfThreaads);
}
