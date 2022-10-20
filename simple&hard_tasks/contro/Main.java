import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int FIGURE_COUNT = 4;

    public static void main(String[] args) {
        int count = 0;
        System.out.println("Input count");
        //Ввод кол-ва фигур в массиве
        Scanner in = new Scanner(System.in);
        count = in.nextInt();
        Figure[] figures = new Figure[count];
        Figure maxFigure = getRandomFigure();
        double max = -1;
        //Добавление фигур и сразу же анализ, максимальная ли площадь у новой фигуры
        for (int i = 0; i < count; i++) {
         figures[i] = getRandomFigure();
         if (figures[i].calcArea() > max) {
             max = figures[i].calcArea();
             maxFigure = figures[i];
         }
        }
        System.out.println("Triangle example: \n" + new RegularTriangle(10));
        System.out.println("Ellipse example: \n" + new Ellipse(10, 20));
        System.out.println("Max figure: \n" + maxFigure.toString());
        System.out.println("Max: " + max);

    }

    public static Figure getRandomFigure() {
        switch (new Random().nextInt(FIGURE_COUNT)) {
            case 0:
                return new Ellipse(new Random().nextDouble(), new Random().nextDouble());
            case 1:
                return new RegularTriangle(new Random().nextDouble());
            case 2:
                return new RegularSquare(new Random().nextDouble());
            case 3:
                return new RegularPentagon(new Random().nextDouble());
        }
        return new Ellipse(new Random().nextDouble(), new Random().nextDouble());

    }
}
