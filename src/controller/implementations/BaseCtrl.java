package controller.implementations;

import controller.interfaces.DialogSubscriber;
import controller.interfaces.ViewController;

import javax.swing.*;

public abstract class BaseCtrl<T extends JPanel> implements ViewController<T>, DialogSubscriber {}
