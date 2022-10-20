package app.encryption;

import app.utils.Application;

import java.util.Scanner;

public class CaesarEncryption extends Encryption {
    protected int rot;
    protected String inputText;
    protected String encryptedText;
    protected Application app;
    protected String ruAlpha = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    protected String enAlpha = "abcdefghijklmnopqrstuvwxyz";

    public CaesarEncryption(Application app) {
        this.app = app;
    }

    @Override
    public String encrypt() {
        init();
        encrypting();
        finish();

        return this.encryptedText;
    }

    protected String encryptText() {
        StringBuilder encrypted = new StringBuilder();
        for (Character ch : inputText.toCharArray()) {
            encrypted.append(rotate(Character.toLowerCase(ch)));
        }
        return encrypted.toString();
    }

    protected char rotate(char ch) {
        for (int i = 0; i < ruAlpha.length(); i++) {
            if (ch == ruAlpha.charAt(i)) {
                return ruAlpha.charAt((i + rot) % ruAlpha.length());
            }
        }

        for (int i = 0; i < enAlpha.length(); i++) {
            if (ch == enAlpha.charAt(i)) {
                return enAlpha.charAt((i + rot) % enAlpha.length());
            }
        }
        return ch;
    }

    private void init() {
        this.inputText = app.getInputText();
        System.out.print("Введите сдвиг: ");
        this.rot = new Scanner(System.in).nextInt();
    }


    private void encrypting() {
        this.encryptedText = encryptText();
    }

    protected void finish() {
        app.setInputText(this.encryptedText);
        app.setCurrentNode(app.getCurrentNode().goToParent());
    }
}
