package Lab15;

import java.io.*;

public class Main {

    private static BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        System.out.println("Что Вы хотите? \n" +
                "1) Сереализовать \n" +
                "2) Просмотреть");

        int userInput = 0;

        while (true) {
            try {
                userInput = Integer.parseInt(scanner.readLine());
                break;
            } catch (NumberFormatException | IOException e) {
                System.out.println("Все сломалось");
            }
        }

        String file = null;

        if (userInput == 1) {
            file = pathToTheFile();
            Oper.saveFile(file);
        } else if (userInput == 2) {
            file = pathToTheFile();
            Oper.lookFile(file);
        } else {
            System.out.println("1 или 2 все просто");
        }
    }

    private static String pathToTheFile() {
        String userInput = null;

        while (true) {
            try {
                userInput = scanner.readLine();
                if (userInput != null && userInput.length() != 0) {
                    break;
                } else {
                    System.out.println("Введите что-нибудь");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Все сломалось");
            }
        }
        return userInput;
    }


}

