package app.encryption;

import app.utils.Application;

import java.util.Scanner;

public class CaesarComplexEncryption extends CaesarEncryption{
    private int alt;

    public CaesarComplexEncryption(Application app) {
        super(app);
    }

    @Override
    public String encrypt() {
        init();
        encrypting();
        finish();

        return this.encryptedText;
    }

    public String encryptText() {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < inputText.length(); i++) {
            if (i % alt == 0) {
                encrypted.append(rotateBack(Character.toLowerCase(inputText.charAt(i))));
            } else {
                encrypted.append(rotate(Character.toLowerCase(inputText.charAt(i))));
            }
        }
        return encrypted.toString();
    }

    private char rotateBack(char ch) {
        for (int i = 0; i < ruAlpha.length(); i++) {
            if (ch == ruAlpha.charAt(i)) {
                int realRot = 0;
                if (i - rot < 0) {
                    realRot = ruAlpha.length() + (i - rot) % ruAlpha.length();
                } else {
                    realRot = i - rot;
                }
                return ruAlpha.charAt((realRot) % ruAlpha.length());
            }
        }

        for (int i = 0; i < enAlpha.length(); i++) {
            if (ch == enAlpha.charAt(i)) {
                int realRot = 0;
                if (i - rot < 0) {
                    realRot = enAlpha.length() + (i - rot) % enAlpha.length();
                } else {
                    realRot = i - rot;
                }
                return enAlpha.charAt((realRot) % enAlpha.length());
            }
        }
        return ch;
    }

    private void init() {
        this.inputText = app.getInputText();
        System.out.print("Введите сдвиг: ");
        this.rot = new Scanner(System.in).nextInt();

        System.out.print("Введите кратность смешивания (2 - каждый второй символ, и тд): ");
        this.alt = new Scanner(System.in).nextInt();
    }

    private void encrypting() {
        this.encryptedText = encryptText();
    }
}
