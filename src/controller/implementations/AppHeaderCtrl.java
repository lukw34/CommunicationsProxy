package controller.implementations;

import controller.interfaces.HeaderCtrlInterface;
import views.Header;
import views.SimpleView;

/**
 * Klasa bedaca kontrolerem naglowka.
 */
public class AppHeaderCtrl implements HeaderCtrlInterface<Header> {

    private SimpleView<Header> header;

    /**
     * Tworzy obiket klasy AppHeaderCtrl
     */
    public AppHeaderCtrl() {
        this.header = new Header();
    }

    /**
     * Metoda udostepnijaca widok.
     *
     * @return Wyrenderowany widok
     */
    @Override
    public Header render() {
        return this.header.drawView();
    }

}
