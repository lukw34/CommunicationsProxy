package controller.interfaces;

/**
 * Interfejs kontrollera, ktory korzysta z danych ustawianych w oknie dialogowym.
 */
public interface DialogSubscriber {
    /**
     * Zapenienie reakcji na zamkniecie okna dialogowego
     */
    void onSubmit();
}