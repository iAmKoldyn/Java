package app.utils;

public class Action {
    private IWorker worker;
    private String actionText;

    public Action(String actionText, IWorker worker) {
        this.actionText = actionText;
        this.worker = worker;
    }

    public Action(String actionText) {
        this.actionText = actionText;
        this.worker = () -> {};
    }

    public String getActionText() {
        return actionText;
    }

    public void doWorker() {
        this.worker.doWork();
    }
}