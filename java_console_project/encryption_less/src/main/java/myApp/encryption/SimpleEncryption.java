package myApp.encryption;

public class SimpleEncryption extends Encryption {
    private char key;

    public SimpleEncryption(String text) {
        super(text);
    }

    public void setKey(char key) {
        this.key = key;
    }

    @Override
    public String encrypt() {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            encrypted.append((char) ((int) text.charAt(i) + distance()));
        }
        return encrypted.toString();
    }

    @Override
    public String decrypt() {
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            decrypted.append((char) ((int) text.charAt(i) - distance()));
        }
        return decrypted.toString();
    }

    private int distance() {
        return (key - 1) % Character.MAX_CODE_POINT;
    }
}
