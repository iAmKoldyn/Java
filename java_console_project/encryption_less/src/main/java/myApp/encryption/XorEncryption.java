package myApp.encryption;

public class XorEncryption extends Encryption {
    private final Integer NUM = 48;
    private String key;

    public XorEncryption(String text) {
        super(text);
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String encrypt() {
        StringBuilder encrypted = new StringBuilder("");
        for (int i = 0; i < text.length(); i++) {
            int o = ((int) text.charAt(i) ^ (int) key.charAt(i % (key.length() - 1))) + '0';
            if (i != text.length() - 1) {
                encrypted.append(o);
                encrypted.append(',');
            } else {
                encrypted.append(o);
            }
        }
        return encrypted.toString();
    }

    @Override
    public String decrypt() {
        StringBuilder decrypted = new StringBuilder();
        String[] input = text.split(",");
        for (int i = 0; i < input.length; i++) {
            decrypted.append((char) ((Integer.parseInt(input[i]) - NUM) ^ (int) key.charAt(i % (key.length() - 1))));
        }
        return decrypted.toString();
    }
}
