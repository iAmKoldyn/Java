package app.encryption;

import app.utils.Application;

import java.util.Scanner;

public class XorEncryption extends Encryption {
    private String key;
    private String inputText;
    private String encryptedText;
    private Application app;

    public XorEncryption(Application app) {
        this.app = app;
    }

    @Override
    public String encrypt() {
        init();
        encrypting();
        finish();

        return this.encryptedText;
    }

    public String encryptText() {
        StringBuilder encrypted = new StringBuilder("");
        for(int i = 0; i < inputText.length(); i++) {
            int o = ((int) inputText.charAt(i) ^ (int) key.charAt(i % (key.length() - 1))) + '0';
            if (i != inputText.length()-1) {
                encrypted.append(o);
                encrypted.append(',');
            } else {
                encrypted.append(o);
            }
        }
        return encrypted.toString();
    }

    private void init() {
        this.inputText = app.getInputText();
        System.out.print("Введите ключ-строку: ");
        this.key = new Scanner(System.in).nextLine();
    }

    private void encrypting() {
        this.encryptedText = encryptText();
    }

    private void finish() {
        app.setInputText(encryptedText);
        app.setCurrentNode(app.getCurrentNode().goToParent());
    }
}
