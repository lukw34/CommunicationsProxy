package views;


import java.awt.*;

public interface SimpleView<T extends Component>  {
    T drawView();
    void setVisible(boolean isVisible);
}
