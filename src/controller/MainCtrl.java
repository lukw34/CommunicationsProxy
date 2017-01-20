package controller;

import models.InitParamsInterface;
import views.Main;
import views.SimpleView;

public class MainCtrl implements ViewController<Main> {
    InitParamsInterface initParams;

    SimpleView<Main> mainView;

    //Controllers
    AgentCtrlInterface agentCtrl;
    MessageBoxesCtrlInterface messageBoxesCtrl;

    public MainCtrl(InitParamsInterface initParams) {
        this.initParams = initParams;
        this.agentCtrl = new AgentCtrl();
        this.messageBoxesCtrl = new MessageBoxesCtrl(initParams);
        this.mainView = new Main(this.agentCtrl, this.messageBoxesCtrl);
    }

    @Override
    public Main render() {
        return mainView.drawView();
    }

    @Override
    public void reRender() {
        mainView.repaint();
        agentCtrl.reRender();
        messageBoxesCtrl.reRender();
    }
}

