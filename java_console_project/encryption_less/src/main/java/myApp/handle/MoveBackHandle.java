package myApp.handle;

import myApp.Menu;

public class MoveBackHandle implements IHandle {
    private Menu menu;

    public MoveBackHandle(Menu menu) {
        this.menu = menu;
    }
    @Override
    public void doHandle() {
        menu.setCurrentNode(menu.getCurrentNode().goToParent().goToParent());
    }
}
