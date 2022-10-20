package process;

import java.util.Random;
import java.util.Scanner;
/*
Создать программу, моделирующую процесс. С клавиатуры задается количество повторений,
размер области и сдвиг относительно начала координат. Заданное количество раз производится генерация 4 случайных чисел
(1 - начало отрезка 1, 2 - конец отрезка 1, 3 - начало отрезка 2, 4 - конец отрезка 2).
 Программа должна выводить на консоль количество пересечений отрезков.
 */
public class Process {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество повторений: ");
        int repeat = scanner.nextInt();

        System.out.print("Введите размер области: ");
        int areaSize = scanner.nextInt();

        System.out.print("Введите сдвиг относительно начала координат: ");
        int shift = scanner.nextInt();

        int intersection = 0;

        for (int i = 0; i < repeat; i++) {
            intersection += countIntersection(areaSize, shift);
        }
        System.out.println("Количество пересечений: " + intersection);

    }

    public static int countIntersection(int areaSize, int shift) {
        int intersection = 0;
        Random random = new Random();

        int segmentBegin_1 = random.nextInt(areaSize + 1) + shift;
        int segmentEnd_1 = random.nextInt(areaSize - segmentBegin_1 + shift + 1) + segmentBegin_1;

        int segmentBegin_2 = random.nextInt(areaSize + 1) + shift;
        int segmentEnd_2 = random.nextInt(areaSize - segmentBegin_2 + shift + 1) + segmentBegin_2;

        if ((segmentEnd_2 - segmentBegin_1 >= 0) || (segmentEnd_1 - segmentBegin_2 <= 0)) {
            intersection++;
        }

        return intersection;
    }

}
