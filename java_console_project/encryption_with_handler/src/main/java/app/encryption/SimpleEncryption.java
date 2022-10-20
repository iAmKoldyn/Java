package app.encryption;

import app.utils.Application;

import java.util.Scanner;

public class SimpleEncryption extends Encryption {
    private char key;
    private String inputText;
    private String encryptedText;
    private Application app;

    public SimpleEncryption(Application app) {
        this.app = app;
    }

    @Override
    public String encrypt() {
        init();
        encrypting();
        finish();

        return encryptedText;
    }

    public String encryptText() {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < inputText.length(); i++) {
            encrypted.append((char) ((int) inputText.charAt(i) + distance()));
        }
        return encrypted.toString();

    }

    private int distance() {
        return (key - 1) % Character.MAX_CODE_POINT;
    }

    private void init() {
        this.inputText = app.getInputText();
        System.out.print("Введите ключ: ");
        this.key = new Scanner(System.in).next().charAt(0);
    }

    private void encrypting() {
        this.encryptedText = encryptText();
    }

    private void finish() {
        app.setInputText(encryptedText);
        app.setCurrentNode(app.getCurrentNode().goToParent());
    }


}
