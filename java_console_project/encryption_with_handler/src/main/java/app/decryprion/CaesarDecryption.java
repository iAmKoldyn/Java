package app.decryprion;

import app.utils.Application;

import java.util.Scanner;

public class CaesarDecryption extends Decryption{
    protected int rot;
    protected String inputText;
    protected String decryptedText;
    protected Application app;
    protected String ruAlpha = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    protected String enAlpha = "abcdefghijklmnopqrstuvwxyz";

    public CaesarDecryption(Application app) {
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
        for (Character ch : inputText.toCharArray()) {
            boolean isEncrypted = false;
            int realRot = 0;
            for (int i = 0; i < ruAlpha.length(); i++) {
                if (ch == ruAlpha.charAt(i)) {
                    if (i - rot < 0) {
                        realRot = ruAlpha.length() + (i - rot) % ruAlpha.length();
                    } else {
                        realRot = i - rot;
                    }
                    decrypted.append(ruAlpha.charAt((realRot) % ruAlpha.length()));
                    isEncrypted = true;
                }
            }

            if (isEncrypted) {
                continue;
            }
            for (int i = 0; i < enAlpha.length(); i++) {
                if (ch == enAlpha.charAt(i)) {
                    if (i - rot < 0) {
                        realRot = enAlpha.length() + (i - rot) % enAlpha.length();
                    } else {
                        realRot = i - rot;
                    }
                    decrypted.append(enAlpha.charAt((realRot) % enAlpha.length()));
                    isEncrypted = true;
                }
            }
            if (isEncrypted) {
                continue;
            }
            decrypted.append(ch);
        }
        return decrypted.toString();
    }

    private void init() {
        this.inputText = app.getInputText();
        System.out.print("Введите сдвиг: ");
        this.rot = new Scanner(System.in).nextInt();
    }

    private void decrypting() {
        this.decryptedText = decryptText();
    }

    protected void finish() {
        app.setInputText(decryptedText);
        app.setCurrentNode(app.getCurrentNode().goToParent());
    }
}
