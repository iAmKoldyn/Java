
public class CaesarEncryption extends Encryption {

     protected int rot;

     protected String ruAlpha= "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

     protected String enAlpha = "abcdefghijklmnopqrstuvwxyz";


    CaesarEncryption(String text, int rot) {
        this.text = text;
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
    public String decrypt(String encrypted) {
        StringBuilder decrypted = new StringBuilder();
        for (Character ch : encrypted.toCharArray()) {
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

    protected char rotate(char ch) {
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
}
