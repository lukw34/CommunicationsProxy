package controller.implementations;

import controller.interfaces.AgentCtrlInterface;
import controller.interfaces.MessageBoxesCtrlInterface;
import models.InitParamsInterface;
import views.Main;
import views.SimpleView;

public class MainCtrl extends BaseCtrl<Main> {
    InitParamsInterface initParams;

    SimpleView<Main> mainView;
    Thread messageBoxes;

    //Controllers
    AgentCtrlInterface agentCtrl;
    MessageBoxesCtrlInterface messageBoxesCtrl;

    public MainCtrl(InitParamsInterface initParams) {
        this.initParams = initParams;
        this.agentCtrl = new AgentCtrl(initParams);
        this.messageBoxesCtrl = new MessageBoxesCtrl(initParams);
        this.mainView = new Main(this.agentCtrl, this.messageBoxesCtrl);
        messageBoxes = new Thread((Runnable) agentCtrl);
        messageBoxes.start();
    }

    @Override
    public Main render() {
        return mainView.drawView();
    }

    @Override
    public void onParamsChange() {
        messageBoxesCtrl.onParamsChange();
        agentCtrl.onParamsChange();
        agentCtrl.unlock();
    }
}

