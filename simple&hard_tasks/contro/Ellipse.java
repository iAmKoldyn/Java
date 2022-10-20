public class Ellipse implements Figure {

    //оси
    private double minAxis;
    private double maxAxis;

    //слои для отображения
    private final String FIRST_LAYER = "\t*\t*";
    private final String SECOND_LAYER = "*\t\t\t*";
    private final String THIRD_LAYER = "*\t\t\t*";
    private final String FOURTH_LAYER = "\t*\t*";

    public Ellipse(double minAxis, double maxAxis) {
        this.minAxis = minAxis;
        this.maxAxis = maxAxis;
    }

    //По формуле считаем площадь pi * a * b
    @Override
    public double calcArea() {
        return Math.PI * maxAxis * minAxis;
    }

    @Override
    public String toString() {
        String ellipse = FIRST_LAYER + "\n";
        ellipse += SECOND_LAYER + "\n";
        ellipse += THIRD_LAYER + "\n";
        ellipse += FOURTH_LAYER + "\t";
        ellipse += "Ellipse with area: " + calcArea();
        return ellipse;
    }
}
