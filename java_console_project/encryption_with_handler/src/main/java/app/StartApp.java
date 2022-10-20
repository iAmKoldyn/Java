package app;

import app.utils.Application;


public class StartApp {
    public static void main(String[] args) {
        Application app = new Application();
        app.setCurrentNode(app.getInitRootNode(app));

        while (true) {
            String enteredText;

            app.showCurrentNodeChildren();
            enteredText = app.waitCommand();
            app.chooseCommand(app, enteredText);
            app.getCurrentNode().doWorker();
        }
    }
}
