package symbol_counter;

public class SymbolCounter {
    public static void main(String[] args) {
        String text = "ddasdasdasdqd";

        System.out.println(getSymbolQuantity(text, 'd'));
    }

    public static int getSymbolQuantity(String text, char symbol) {
        int counter = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == symbol) counter++;  // if symb =
        }
        return counter;
    }
}
