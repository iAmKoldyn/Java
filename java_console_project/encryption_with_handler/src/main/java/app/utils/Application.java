package app.utils;

import app.decryprion.CaesarComplexDecryption;
import app.decryprion.CaesarDecryption;
import app.decryprion.SimpleDecryption;
import app.decryprion.XorDecryption;
import app.encryption.CaesarComplexEncryption;
import app.encryption.CaesarEncryption;
import app.encryption.SimpleEncryption;
import app.encryption.XorEncryption;
import app.handle.ExitHandle;
import app.handle.MoveHandle;
import app.handle.SetTextHandle;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    private String inputText;
    private Node currentNode;

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

    public Node getInitRootNode(Application app) {
        return initRootNode(app);
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

    public void chooseCommand(Application app, String enteredText) {
        app.getCurrentNode().getChildren().stream().filter(node -> node.getAction().getActionText().contains(enteredText))
                .findFirst().ifPresentOrElse(app::setCurrentNode, () -> {
                    System.out.printf("Комманда {%s} не найдена!\n",enteredText);
                    app.setCurrentNode(getCurrentNode());
                } );
    }

    private Node initRootNode(Application app) {
        Node backToFirstLevelNode = new Node(new Action("5. Вернуться назад", new MoveHandle(app)));

        Node xorDecryptionNode = new Node(new Action("4. XorDecryption", new XorDecryption(app)));
        Node caesarComplexDecryptionNode = new Node(new Action("3. CaesarComplexDecryption", new CaesarComplexDecryption(app)));
        Node caesarDecryptionNode = new Node(new Action("2. CaesarDecryption", new CaesarDecryption(app)));
        Node simpleDecryptionNode = new Node(new Action("1. SimpleDecryption", new SimpleDecryption(app)));
        List<Node> decryptLevelNodes = Arrays.asList(simpleDecryptionNode, caesarDecryptionNode, caesarComplexDecryptionNode, xorDecryptionNode, backToFirstLevelNode);

        Node xorEncryptionNode = new Node(new Action("4. XorEncryption", new XorEncryption(app)));
        Node caesarComplexEncryptionNode = new Node(new Action("3. CaesarComplexEncryption", new CaesarComplexEncryption(app)));
        Node caesarEncryptionNode = new Node(new Action("2. CaesarEncryption", new CaesarEncryption(app)));
        Node simpleEncryptionNode = new Node(new Action("1. SimpleEncryption", new SimpleEncryption(app)));
        List<Node> encryptLevelNodes = Arrays.asList(simpleEncryptionNode, caesarEncryptionNode, caesarComplexEncryptionNode, xorEncryptionNode, backToFirstLevelNode);

        Node encryptNode = new Node(new Action("2. Шифрофание"), encryptLevelNodes);
        Node decryptNode = new Node(new Action("3. Расшифровка"), decryptLevelNodes);
        Node exitProgramNode = new Node(new Action("4. Выход", new ExitHandle()));
        Node inputTextNode = new Node(new Action("1. Ввести текст", new SetTextHandle(app)));
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