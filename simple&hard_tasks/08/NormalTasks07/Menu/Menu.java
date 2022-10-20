package Menu;

import java.util.Scanner;

import Menu.Action.*;

public class Menu {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Node node0 = new Node(2, new Action("\n Какие-то цитаты со смыслом. \n", MessageSet.INFORMATIONT_DESCRIPTION, 2));

        Node node1 = new Node(2, new Action("\n Майкл Джордан \n", MessageSet.SEE_DESCRIPTION, 2));

        Node node2 = new Node(2, new Action("\n Фазиль Искандер \n", MessageSet.SEE_ANOTHER_DESCRIPTION, 2));

        Node node11 = new Node(0, new Action("\n Неосмысленная жизнь не стоит того, чтобы жить. \n", MessageSet.TEXT_DESCRIPTION, 0));

        Node node12 = new Node(0, new Action("\n Сложнее всего начать действовать, все остальное зависит только от упорства. \n", MessageSet.TEXT_DESCRIPTION, 0));

        Node node21 = new Node(0, new Action("\n Стоит только поверить, что вы можете – и вы уже на полпути к цели. \n", MessageSet.TEXT_DESCRIPTION, 0));

        Node node22 = new Node(0, new Action("\n Лучше быть уверенным в хорошем результате, чем надеяться на отличный. \n", MessageSet.TEXT_DESCRIPTION, 0));
        node0.children[0] = node1;
        node0.children[1] = node2;
        node1.setParent(node0);
        node2.setParent(node0);
        node1.children[0] = node12;
        node1.children[1] = node11;
        node2.children[0] = node22;
        node2.children[1] = node21;
        node12.setParent(node1);
        node11.setParent(node1);
        node21.setParent(node2);
        node22.setParent(node2);
        Node node = node0;
        int userInput = 0;
        boolean go = true;

        while(go){
            System.out.println(node.getItem());
            for (int i = 0; i < node.getChildren().length; i++) {
                System.out.println(MessageSet.PRESS + (i + 2) + MessageSet.THEN + node.getChildren()[i].getAction().getDescription());
            }
            userInput = scanner.nextInt();
            System.out.println();
            if (userInput == 0){
                if (node.hasParent()){
                    go = false;
                }
                else{
                    node = node.getParent();
                }
            }
            if (userInput > 0 && userInput <= node.sizeAction()){
                node.doAction();
            }
            if (userInput > node.sizeAction() && userInput <= node.sizeChildren() + 1){
                node = node.goToChild(userInput - node.sizeAction() - 1);
           }
        }
    }
}
