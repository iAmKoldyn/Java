package app.handle;

import app.utils.IWorker;

public class ExitHandle implements IWorker {
    @Override
    public void doWork() {
        System.exit(0);
    }

}
