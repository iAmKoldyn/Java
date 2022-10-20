package myApp.encryption;

public abstract class Encryption {
    protected String text;

    public Encryption(String text) {
        this.text = text;
    };

    public abstract String encrypt();
    public abstract String decrypt();

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
