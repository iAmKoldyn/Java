package app.decryprion;

import app.utils.Application;

import java.util.Scanner;

public class SimpleDecryption extends Decryption {
    private char key;
    private String inputText;
    private String decryptedText;
    private Application app;

    public SimpleDecryption(Application app) {
        this.app = app;
    }

    @Override
    public String decrypt() {
        init();
        decrypting();
        finish();

        return this.decryptedText;
    }

    public String decryptText() {
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < inputText.length(); i++) {
            decrypted.append((char) ((int) inputText.charAt(i) - distance()));
        }
        return decrypted.toString();
    }

    int distance() {
        return (key - 1) % Character.MAX_CODE_POINT;
    }

    private void init() {
        this.inputText = app.getInputText();
        System.out.print("Введите ключ: ");
        this.key = new Scanner(System.in).next().charAt(0);
    }

    private void decrypting() {
        this.decryptedText = decryptText();
    }

    private void finish() {
        app.setInputText(decryptedText);
        app.setCurrentNode(app.getCurrentNode().goToParent());
    }
}
