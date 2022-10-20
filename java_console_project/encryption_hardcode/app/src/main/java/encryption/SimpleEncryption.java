public class SimpleEncryption extends Encryption {
    private char key;

    SimpleEncryption(String text, char key) {
        this.text = text;
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
    public String decrypt(String encrypted) {
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < encrypted.length(); i++) {
            decrypted.append((char) ((int)encrypted.charAt(i) - distance()));
        }
        return decrypted.toString();
    }

    int distance() {
        return (key - 1) % Character.MAX_CODE_POINT;
    }
}
