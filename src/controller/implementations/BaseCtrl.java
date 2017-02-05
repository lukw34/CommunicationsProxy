package controller.implementations;

import controller.interfaces.DialogSubscriber;
import controller.interfaces.ViewController;

import javax.swing.*;

/**
 * Bazowy kontroloer bedacy klasa abstrakcyjna w celu zgrupowania interfejsow.
 *
 * @param <T> Widok do ktorego podpiety jest kontroler.
 */
public abstract class BaseCtrl<T extends JPanel> implements ViewController<T>, DialogSubscriber {}
