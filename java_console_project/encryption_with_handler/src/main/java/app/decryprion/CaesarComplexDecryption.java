package app.decryprion;

import app.utils.Application;

import java.util.Scanner;

public class CaesarComplexDecryption extends CaesarDecryption {
    private int alt;

    public CaesarComplexDecryption(Application app) {
        super(app);
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
            if (i % alt == 0) {
                decrypted.append(rotate(inputText.charAt(i)));
            } else {
                decrypted.append(rotateBack(inputText.charAt(i)));
            }
        }
        return decrypted.toString();
    }

    private char rotate(char ch) {
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

    private void decrypting() {
        this.decryptedText = decryptText();
    }

}
