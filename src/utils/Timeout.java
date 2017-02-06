package utils;

/**
 * Klasa generujaca losowy timeout.
 */
public class Timeout {

    /**
     * Generuje wartosc w podanym zakresie.
     *
     * @param min Dolny zakres.
     * @param max Gorny zakres
     * @return Losowa wartosc opoznienia.
     */
    public static  int getTimeout(int min, int max) {
        return (int)(Math.random() * max + min);
    }
}
