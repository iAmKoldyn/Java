package myApp.encryption;

public class CaesarComplexEncryption extends CaesarEncryption {
    private int alt;

    public CaesarComplexEncryption(String text) {
        super(text);
    }

    public void setAlt(int alt) {
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
    public String decrypt() {
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (i % alt == 0) {
                decrypted.append(rotate(text.charAt(i)));
            } else {
                decrypted.append(rotateBack(text.charAt(i)));
            }
        }
        return decrypted.toString();
    }

    private char rotateBack(char ch) {
        for (int i = 0; i < RU_ALPHA.length(); i++) {
            if (ch == RU_ALPHA.charAt(i)) {
                int realRot = 0;
                if (i - rot < 0) {
                    realRot = RU_ALPHA.length() + (i - rot) % RU_ALPHA.length();
                } else {
                    realRot = i - rot;
                }
                return RU_ALPHA.charAt((realRot) % RU_ALPHA.length());
            }
        }

        for (int i = 0; i < EN_ALPHA.length(); i++) {
            if (ch == EN_ALPHA.charAt(i)) {
                int realRot = 0;
                if (i - rot < 0) {
                    realRot = EN_ALPHA.length() + (i - rot) % EN_ALPHA.length();
                } else {
                    realRot = i - rot;
                }
                return EN_ALPHA.charAt((realRot) % EN_ALPHA.length());
            }
        }
        return ch;
    }
}
