package app.handle;

import app.utils.IWorker;
import app.utils.Application;

import java.util.Scanner;

public class SetTextHandle implements IWorker {
    private Application app;

    public SetTextHandle(Application app) {
        this.app = app;
    }

    @Override
    public void doWork() {
        System.out.print("Введите текст с которым хотите работать: ");
        app.setInputText(new Scanner(System.in).nextLine());
        app.setCurrentNode(app.getCurrentNode().goToParent());
    }
}
