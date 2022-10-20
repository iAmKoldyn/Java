public class XorEncryption extends Encryption {
    private String key;
    final int CONSTANT = 48;
    XorEncryption(String text, String key) {
        this.text = text;
        this.key = key;
    }

    @Override
    public String encrypt() {
        StringBuilder encrypted = new StringBuilder("");
        for(int i = 0; i < text.length(); i++) {
            int o = ((int) text.charAt(i) ^ (int) key.charAt(i % (key.length() - 1))) + '0';
            if (i != text.length()-1) {
                encrypted.append(o);
                encrypted.append(',');
            } else {
                encrypted.append(o);
            }
        }
        return encrypted.toString();
    }

    @Override
    public String decrypt(String encrypted) {
        StringBuilder decrypted = new StringBuilder();
        String[] input = encrypted.split(",");
        for(int i = 0; i < input.length; i++) {
            decrypted.append((char) ((Integer.parseInt(input[i]) - CONSTANT) ^ (int) key.charAt(i % (key.length() - 1))));
        }
        return decrypted.toString();
    }
}
