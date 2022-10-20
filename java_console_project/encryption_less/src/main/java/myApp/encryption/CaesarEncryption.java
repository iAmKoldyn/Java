package myApp.encryption;


public class CaesarEncryption extends Encryption {
    protected final String RU_ALPHA = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    protected final String EN_ALPHA = "abcdefghijklmnopqrstuvwxyz";
    protected int rot;

    public CaesarEncryption(String text) {
        super(text);
    }

    public void setRot(int rot) {
        this.rot = rot;
    }

    @Override
    public String encrypt() {
        StringBuilder encrypted = new StringBuilder();
        for (Character ch : text.toCharArray()) {
            encrypted.append(rotate(Character.toLowerCase(ch)));
        }
        return encrypted.toString();
    }

    @Override
    public String decrypt() {
        StringBuilder decrypted = new StringBuilder();
        for (Character ch : text.toCharArray()) {
            boolean isEncrypted = false;
            int realRot = 0;
            for (int i = 0; i < RU_ALPHA.length(); i++) {
                if (ch == RU_ALPHA.charAt(i)) {
                    if (i - rot < 0) {
                        realRot = RU_ALPHA.length() + (i - rot) % RU_ALPHA.length();
                    } else {
                        realRot = i - rot;
                    }
                    decrypted.append(RU_ALPHA.charAt((realRot) % RU_ALPHA.length()));
                    isEncrypted = true;
                }
            }

            if (isEncrypted) {
                continue;
            }
            for (int i = 0; i < EN_ALPHA.length(); i++) {
                if (ch == EN_ALPHA.charAt(i)) {
                    if (i - rot < 0) {
                        realRot = EN_ALPHA.length() + (i - rot) % EN_ALPHA.length();
                    } else {
                        realRot = i - rot;
                    }
                    decrypted.append(EN_ALPHA.charAt((realRot) % EN_ALPHA.length()));
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

    protected char rotate(char ch) {
        for (int i = 0; i < RU_ALPHA.length(); i++) {
            if (ch == RU_ALPHA.charAt(i)) {
                return RU_ALPHA.charAt((i + rot) % RU_ALPHA.length());
            }
        }

        for (int i = 0; i < EN_ALPHA.length(); i++) {
            if (ch == EN_ALPHA.charAt(i)) {
                return EN_ALPHA.charAt((i + rot) % EN_ALPHA.length());
            }
        }
        return ch;
    }
}
