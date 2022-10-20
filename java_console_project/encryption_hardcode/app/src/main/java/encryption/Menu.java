import java.util.Scanner;

public class Menu {
    int depth;
    String text;
    Tree menu;

    public static void main(String[] args) {
        Menu mn = new Menu();
        mn.init();
        mn.depth = 1;
        while (true) {
            mn.handleMenu();
        }
    }

    void handleMenu() {
        switch (depth) {
            case 1:
                handleDepth1();
                break;
            case 2:
                handleDepth2();
                break;
            case 3:
                handleDepth3();
                break;
            default:
                throw new IllegalStateException();
        }
    }

    void handleDepth1() {
        menu.printNodes();
        System.out.println("Введите команду:");
        String operationId = new Scanner(System.in).nextLine();
        switch (operationId) {
            case ID1_1:
                System.out.println("Введите текст");
                depth = 2;
                menu.moveForward();
                text = new Scanner(System.in).nextLine();
                break;
            case ID1_2:
                System.out.println("Введите зашифрованный текст");
                depth = 3;
                menu.moveForward();
                text = new Scanner(System.in).nextLine();
                break;
            case ID1_3:
                System.out.println("До свидания");
                System.exit(0);
        }
    }

    void handleDepth2() {
        menu.printNodes();
        System.out.println("Введите команду:");
        String operationId = new Scanner(System.in).nextLine();
        switch (operationId) {
            case ID2_1:
                System.out.println("Введите сдвиг");
                int rot = Integer.parseInt(new Scanner(System.in).nextLine());
                CaesarEncryption caesarEncryption = new CaesarEncryption(text, rot);
                System.out.println("Зашифровано: " + caesarEncryption.encrypt());
                break;
            case ID2_2:
                System.out.println("Введите сдвиг");
                int rotCompl = Integer.parseInt(new Scanner(System.in).nextLine());
                System.out.println("Введите кратность смешивания (2 - каждый второй символ, и тд)");
                int alt = Integer.parseInt(new Scanner(System.in).nextLine());
                CaesarComplexEncryption caesarComplexEncryption = new CaesarComplexEncryption(text, rotCompl, alt);
                System.out.println("Зашифровано: " + caesarComplexEncryption.encrypt());
                break;
            case ID2_3:
                System.out.println("Введите ключ-символ:");
                char keySym = (new Scanner(System.in).nextLine()).charAt(0);
                System.out.println("Зашифровано: " + new SimpleEncryption(text, keySym).encrypt());
                break;
            case ID2_4:
                System.out.println("Введите ключ-строку:");
                String key = (new Scanner(System.in).nextLine());
                System.out.println("Зашифровано: " + new XorEncryption(text, key).encrypt());
                break;
            case ID2_5:
                menu.moveBack();
                depth = 1;
                break;
            case ID2_6:
                System.out.println("До свидания");
                System.exit(0);
        }
    }

    void handleDepth3() {
        menu.printNodes();
        System.out.println("Введите команду:");
        String operationId = new Scanner(System.in).nextLine();
        switch (operationId) {
            case ID2_1:
                System.out.println("Введите сдвиг");
                int rot = Integer.parseInt(new Scanner(System.in).nextLine());
                CaesarEncryption caesarEncryption = new CaesarEncryption(text, rot);
                System.out.println("Расшифровано: " + caesarEncryption.decrypt(text));
                break;
            case ID2_2:
                System.out.println("Введите сдвиг");
                int rotCompl = Integer.parseInt(new Scanner(System.in).nextLine());
                System.out.println("Введите кратность смешивания (2 - каждый второй символ, и тд)");
                int alt = Integer.parseInt(new Scanner(System.in).nextLine());
                CaesarComplexEncryption caesarComplexEncryption = new CaesarComplexEncryption(text, rotCompl, alt);
                System.out.println("Расшифровано: " + caesarComplexEncryption.decrypt(text));
                break;
            case ID2_3:
                System.out.println("Введите ключ-символ:");
                char keySym = (new Scanner(System.in).nextLine()).charAt(0);
                System.out.println("Расшифровано: " + new SimpleEncryption(text, keySym).decrypt(text));
                break;
            case ID2_4:
                System.out.println("Введите ключ-строку:");
                String key = (new Scanner(System.in).nextLine());
                System.out.println("Расшифровано: " + new XorEncryption(text, key).decrypt(text));
                break;
            case ID2_5:
                depth = 1;
                menu.moveBack();
                break;
            case ID2_6:
                System.out.println("До свидания");
                System.exit(0);
        }
    }

    public void init() {

        Node<MenuItem>[] nodes1 = new Node[3];
        nodes1[0] = new Node<MenuItem>(new MenuItem(ID1_1, DES1_1));
        nodes1[1] = new Node<MenuItem>(new MenuItem(ID1_2, DES1_2));
        nodes1[2] = new Node<MenuItem>(new MenuItem(ID1_3, DES1_3));

        Node<MenuItem>[] nodes2 = new Node[6];
        nodes2[0] = new Node<MenuItem>(new MenuItem(ID2_1, DES2_1));
        nodes2[1] = new Node<MenuItem>(new MenuItem(ID2_2, DES2_2));
        nodes2[2] = new Node<MenuItem>(new MenuItem(ID2_3, DES2_3));
        nodes2[3] = new Node<MenuItem>(new MenuItem(ID2_4, DES2_4));
        nodes2[4] = new Node<MenuItem>(new MenuItem(ID2_5, DES2_5));
        nodes2[5] = new Node<MenuItem>(new MenuItem(ID2_6, DES2_6));

        TreeItem<Node<MenuItem>> item1 = new TreeItem<>(nodes1);
        TreeItem<Node<MenuItem>> item2 = new TreeItem<>(nodes2);
        item1.prev = null;
        item1.next = item2;

        item2.prev = item1;
        item2.next = null;
        menu = new Tree<>();

        menu.head = item1;
        menu.currentNode = menu.head;

    }

    final String ID1_1 = "1";
    final String DES1_1 = "Ввести текст";

    final String ID1_2 = "2";
    final String DES1_2 = "Дешифровать текст";

    final String ID1_3 = "3";
    final String DES1_3 = "Выход";

    final String ID2_1 = "1";
    final String DES2_1 = "Шифр цезаря";

    final String ID2_2 = "2";
    final String DES2_2 = "Шифр цезаря запутанный";

    final String ID2_3 = "3";
    final String DES2_3 = "Простой шифр";

    final String ID2_4 = "4";
    final String DES2_4 = "XoR шифр";

    final String ID2_5 = "5";
    final String DES2_5 = "Вернуться назад";

    final String ID2_6 = "6";
    final String DES2_6 = "Выход";
}
