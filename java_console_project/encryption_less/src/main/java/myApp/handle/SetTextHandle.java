package myApp.handle;

import myApp.Menu;

import java.util.Scanner;

public class SetTextHandle implements IHandle{
    private Menu menu;

    public SetTextHandle(Menu menu) {
        this.menu = menu;
    }
    @Override
    public void doHandle() {
        System.out.print("Введите текст с которым хотите работать: ");
        menu.setInputText(new Scanner(System.in).nextLine());
        menu.setCurrentNode(menu.getCurrentNode().goToParent());
    }
}
