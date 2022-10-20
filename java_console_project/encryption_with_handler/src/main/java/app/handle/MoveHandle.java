package app.handle;

import app.utils.IWorker;
import app.utils.Application;

public class MoveHandle implements IWorker {
    private Application app;

    public MoveHandle(Application app) {
        this.app = app;
    }

    @Override
    public void doWork() {
        app.setCurrentNode(app.getCurrentNode().goToParent().goToParent());
    }
}
