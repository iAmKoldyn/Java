public class CaesarComplexEncryption extends CaesarEncryption {
    private int alt;

    public CaesarComplexEncryption(String text, int rot, int alt) {
        super(text, rot);
        this.alt = alt;
    }

    @Override
    public String encrypt() {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (i % alt == 0) {
                encrypted.append(rotateBack(Character.toLowerCase(text.charAt(i))));
            } else {
                encrypted.append(rotate(Character.toLowerCase(text.charAt(i))));
            }
        }
        return encrypted.toString();
    }

    @Override
    public String decrypt(String encrypted) {
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < encrypted.length(); i++) {
            if (i % alt == 0) {
                decrypted.append(rotate(encrypted.charAt(i)));
            } else {
                decrypted.append(rotateBack(encrypted.charAt(i)));
            }
        }
        return decrypted.toString();
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
}
