package myApp;

import myApp.encryption.*;
import myApp.handle.IHandle;

import java.util.Scanner;

public class Action {
    private String actionText;
    private Encryption encryption;
    private ActionType type;
    private IHandle handle;
    private Menu menu;

    public Action(String actionText) {
        this.actionText = actionText;
        this.type = ActionType.NONE;
    }

    public Action(String actionText, Menu menu, Encryption encryption, ActionType type) {
        this.actionText = actionText;
        this.encryption = encryption;
        this.type = type;
        this.menu = menu;
    }

    public Action(String actionText, IHandle handle) {
        this.actionText = actionText;
        this.handle = handle;
        this.type = ActionType.HANDLE;
    }

    public String getActionText() {
        return actionText;
    }

    public void doAction() {
        switch (type) {
            case ENCRYPT -> {
                choiceEncryption();
                nodeOut(encrypt());
                System.out.printf("\nРезультат шифрования = %s\n", (menu.getInputText()));
            }
            case DECRYPT -> {
                choiceEncryption();
                nodeOut(decrypt());
                System.out.printf("\nРезультат дешифровки = %s\n", (menu.getInputText()));
            }
            case HANDLE -> {
                handle();
            }
            default -> {
            }
        };
    }

    private String encrypt() {
        return this.encryption.encrypt();
    }

    private String decrypt() {
        return this.encryption.decrypt();
    }

    private void handle() {
        this.handle.doHandle();
    }

    private void choiceEncryption() {
        String encryptionName = this.encryption.getClass().getSimpleName();
        Encryption encryptionClass = encryption;
        encryptionClass.setText(menu.getInputText());

        switch (encryptionName) {
            case "CaesarEncryption" -> {
                System.out.print("Введите сдвиг: ");
                CaesarEncryption caesarEncryption = (CaesarEncryption) encryption;
                caesarEncryption.setRot(new Scanner(System.in).nextInt());
            }
            case "SimpleEncryption" -> {
                System.out.print("Введите ключ: ");
                SimpleEncryption simpleEncryption = (SimpleEncryption) encryption;
                simpleEncryption.setKey(new Scanner(System.in).next().charAt(0));
            }
            case "CaesarComplexEncryption" -> {
                System.out.print("Введите сдвиг: ");
                CaesarComplexEncryption caesarComplexEncryption = (CaesarComplexEncryption) encryption;
                caesarComplexEncryption.setRot(new Scanner(System.in).nextInt());
                System.out.print("Введите кратность смешивания (2 - каждый второй символ, и тд): ");
                caesarComplexEncryption.setAlt(new Scanner(System.in).nextInt());
            }
            case "XorEncryption" -> {
                System.out.print("Введите ключ-строку: ");
                XorEncryption xorEncryption = (XorEncryption) encryption;
                xorEncryption.setKey(new Scanner(System.in).nextLine());
            }
        }
    }

    private void nodeOut(String text) {
        menu.setInputText(text);
        menu.setCurrentNode(menu.getCurrentNode().goToParent());
    }
}
