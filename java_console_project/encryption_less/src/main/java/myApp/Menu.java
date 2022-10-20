package myApp;

import myApp.encryption.*;
import myApp.handle.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private String inputText;
    private Node currentNode;


    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.setCurrentNode(menu.getInitRootNode(menu));

        while (true) {
            String enteredText;

            menu.showCurrentNodeChildren();
            enteredText = menu.waitCommand();
            menu.chooseCommand(menu, enteredText);
            menu.getCurrentNode().action.doAction();
        }
    }

    public String getInputText() {
        return this.inputText;
    }

    public void setInputText(String text) {
        this.inputText = text;
    }

    public Node getCurrentNode() {
        return this.currentNode;
    }

    public void setCurrentNode(Node node) {
        this.currentNode = node;
    }

    public Node getInitRootNode(Menu menu) {
        return initRootNode(menu);
    }

    public void showCurrentNodeChildren() {
        currentNode.getChildren().forEach(node -> System.out.println(node.action.getActionText()));
    }

    public String waitCommand() {
        System.out.print("Введите комманду: ");
        String enteredText = new Scanner(System.in).nextLine();
        System.out.println();
        return enteredText;
    }

    public void chooseCommand(Menu menu, String enteredText) {
        menu.getCurrentNode().getChildren().stream().filter(node -> node.getAction().getActionText().contains(enteredText))
                .findFirst().ifPresentOrElse(menu::setCurrentNode, () -> {
                    System.out.printf("Комманда {%s} не найдена!\n",enteredText);
                    menu.setCurrentNode(getCurrentNode());
                } );
    }

    private Node initRootNode(Menu menu) {
        Node backToFirstLevelNode = new Node(new Action("5. Вернуться назад", new MoveBackHandle(menu)));

        Node xorDecryptionNode = new Node(new Action("4. XorDecryption", menu, new XorEncryption(inputText), ActionType.DECRYPT));
        Node caesarComplexDecryptionNode = new Node(new Action("3. CaesarComplexDecryption", menu, new CaesarComplexEncryption(inputText), ActionType.DECRYPT));
        Node caesarDecryptionNode = new Node(new Action("2. CaesarDecryption", menu, new CaesarEncryption(inputText), ActionType.DECRYPT));
        Node simpleDecryptionNode = new Node(new Action("1. SimpleDecryption", menu, new SimpleEncryption(inputText), ActionType.DECRYPT));
        List<Node> decryptLevelNodes = Arrays.asList(simpleDecryptionNode, caesarDecryptionNode, caesarComplexDecryptionNode, xorDecryptionNode, backToFirstLevelNode);

        Node xorEncryptionNode = new Node(new Action("4. XorEncryption", menu, new XorEncryption(inputText), ActionType.ENCRYPT));
        Node caesarComplexEncryptionNode = new Node(new Action("3. CaesarComplexEncryption", menu, new CaesarComplexEncryption(inputText), ActionType.ENCRYPT));
        Node caesarEncryptionNode = new Node(new Action("2. CaesarEncryption", menu, new CaesarEncryption(inputText), ActionType.ENCRYPT));
        Node simpleEncryptionNode = new Node(new Action("1. SimpleEncryption", menu, new SimpleEncryption(inputText), ActionType.ENCRYPT));
        List<Node> encryptLevelNodes = Arrays.asList(simpleEncryptionNode, caesarEncryptionNode, caesarComplexEncryptionNode, xorEncryptionNode, backToFirstLevelNode);

        Node encryptNode = new Node(new Action("2. Шифрофание"), encryptLevelNodes);
        Node decryptNode = new Node(new Action("3. Расшифровка"), decryptLevelNodes);
        Node exitProgramNode = new Node(new Action("4. Выход", new ExitHandle()));
        Node inputTextNode = new Node(new Action("1. Ввести текст", new SetTextHandle(menu)));
        List<Node> firstLevelNodes = Arrays.asList(inputTextNode, encryptNode, decryptNode, exitProgramNode);

        Node rootNode = new Node(new Action("Запуск программы"), firstLevelNodes);

        //главный уровень узлов
        inputTextNode.setParent(rootNode);
        encryptNode.setParent(rootNode);
        decryptNode.setParent(rootNode);
        exitProgramNode.setParent(rootNode);

        //уровень шифрования
        simpleEncryptionNode.setParent(encryptNode);
        caesarEncryptionNode.setParent(encryptNode);
        caesarComplexEncryptionNode.setParent(encryptNode);
        xorEncryptionNode.setParent(encryptNode);
        backToFirstLevelNode.setParent(encryptNode);

        //уровень дешифровки
        simpleDecryptionNode.setParent(decryptNode);
        caesarDecryptionNode.setParent(decryptNode);
        caesarComplexDecryptionNode.setParent(decryptNode);
        xorDecryptionNode.setParent(decryptNode);
        backToFirstLevelNode.setParent(decryptNode);

        return rootNode;
    }

}
