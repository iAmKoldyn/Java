package generator;

import java.util.Scanner;

/*
Пользователь вводит с клавиатуры количество чисел. Программа должна случайным образом генерировать введенное количество
чисел и выводить время генерации. Если время генерации больше 5 секунд, то выводить сообщение "превышено допустимое время
работы программы, введите количество поменьше". Если время генерации меньше 5 секунд, то выводить сгенерированные
числа в консоль через запятую.
*/
public class NumberGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество генерируемых чисел: ");

        int quantityNumbers = scanner.nextInt();

        Generator generator = new Generator(quantityNumbers, 5000);

        int[] generatedNumbers = generator.getRandomNumbersArray();

        if (generatedNumbers != null) {
            for (int i = 0; i < generatedNumbers.length; i++) {
                System.out.print(generatedNumbers[i]);
                if (i == generatedNumbers.length - 1) break;
                System.out.print(", ");
            }
        } else {
            System.out.println("Превышено допустимое время работы программы, введите количество поменьше!");
        }
    }
}
