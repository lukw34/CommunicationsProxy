package controller;


import views.Agent;
import views.SimpleView;

public class AgentCtrl implements AgentCtrlInterface<Agent>{
    SimpleView<Agent> agentView;

    public AgentCtrl() {
        agentView = new Agent(this);
    }

    @Override
    public Agent render() {
        return agentView.drawView();
    }

    @Override
    public void reRender() {
        agentView.repaint();
    }
}
