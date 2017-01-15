package controller;

import java.awt.*;

public interface ViewController<T extends Component> {
    T render();
}
