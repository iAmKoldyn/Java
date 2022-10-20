package generate_random_renge;
/*
Создать программу, моделирующую случайный процесс. С клавиатуры задается некий "порог" в виде вещественного числа,
коэффициент влияния порога и максимальное время моделирования. В случайные моменты времени
генерируются случайные вещественные числа в интервале[-коэффициент*порог; коэффициент*порог].
 Если сгенерированное число больше заданного порога, то прекратить моделирование.
 По завершении моделирования вывести следующую информацию на консоль: <время от начала эксперимента>: <число>
 */
import java.util.Random;
import java.util.Scanner;

public class Process {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите порог диапазона: ");
        double thresholdRange = scanner.nextDouble();
        System.out.print("Введите коэффициент влияния порога(>1.0): ");
        double ratioThreshold = scanner.nextDouble();

        System.out.print("Введите максимальное время моделирования в секундах: ");
        int maxDelayTime = scanner.nextInt();

        long beginProcess = System.currentTimeMillis();

        double range = thresholdRange * ratioThreshold;//D+Dk
        double randomNumber;
        while (true) {
            randomNumber = generateRandomNumber(-Math.abs(range), Math.abs(range));//G/CH
            if (randomNumber > thresholdRange) break;

            Thread.sleep(generateRandomTime(maxDelayTime));
        }

        long endProcess = System.currentTimeMillis();

        long timeProcess = endProcess - beginProcess;

        System.out.println("Время от начала эксперимента: " + timeProcess + " миллисекунд.");
    }

    public static double generateRandomNumber(double bottom, double top) {
            double generateRandomNumber = (Math.random() * ((top - bottom) + 1)) + bottom;
        System.out.println(generateRandomNumber);
        return generateRandomNumber;
    }

    public static long generateRandomTime(int maxTime) {
        Random random = new Random();
        return random.nextInt(maxTime) * 1000L;
    }
}
