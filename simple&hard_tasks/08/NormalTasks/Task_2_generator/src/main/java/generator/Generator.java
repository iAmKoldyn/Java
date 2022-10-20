package generator;

import java.util.Date;
import java.util.Random;

public class Generator {
    private final int[] randomNumbersArray;
    private final long threshold;
    private long timeForGenerateNumbers;

    public Generator(int numbers, int threshold) {
        this.randomNumbersArray = new int[numbers];
        this.threshold = threshold;
        generate();
    }

    public int[] getRandomNumbersArray() {
        if (this.timeForGenerateNumbers < this.threshold) {
            return this.randomNumbersArray;
        }
        else {
            return null;
        }
    }

    public void generate() { // Метод генерации случайных чисел
        Random random = new Random();

        long begin = new Date().getTime();

        for (int i = 0; i < randomNumbersArray.length; i++) {
            randomNumbersArray[i] = random.nextInt(10_000);
        }

        timeForGenerateNumbers = new Date().getTime() - begin;
    }
}
