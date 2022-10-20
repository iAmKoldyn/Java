package app.decryprion;

import app.utils.Application;

import java.util.Scanner;

public class XorDecryption extends Decryption{
    private String key;
    private String inputText;
    private String decryptedText;
    private Application app;
    private final Integer num = 48;

    public XorDecryption(Application app) {
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
        String[] input = inputText.split(",");
        for(int i = 0; i < input.length; i++) {
            decrypted.append((char) ((Integer.parseInt(input[i]) - num) ^ (int) key.charAt(i % (key.length() - 1))));
        }
        return decrypted.toString();
    }
    private void init() {
        this.inputText = app.getInputText();
        System.out.print("Введите ключ-строку: ");
        this.key = new Scanner(System.in).nextLine();
    }

    private void decrypting() {
        this.decryptedText = decryptText();
    }

    private void finish() {
        app.setInputText(decryptedText);
        app.setCurrentNode(app.getCurrentNode().goToParent());
    }
}
