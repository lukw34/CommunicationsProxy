package views;


public interface SimpleView <T> {
    T render();
    void setVisible(boolean isVisible);
}
