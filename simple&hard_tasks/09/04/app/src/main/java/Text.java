public class Text implements Printable {
    private String text;
    private String textColor;

    public Text(String text, String textColor) {
        this.text = text;
        this.textColor = textColor;
    }

    @Override
    public String toString() {
        return "Текст{" +
                "текст='" + text + '\'' +
                ", эмоциональная окраска='" + textColor + '\'' +
                '}';
    }

    @Override
    public void print() {
        System.out.println(this);
    }
}
