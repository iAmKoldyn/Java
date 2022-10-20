package myApp.handle;

public class ExitHandle implements IHandle{
    @Override
    public void doHandle() {
        System.exit(0);
    }
}
