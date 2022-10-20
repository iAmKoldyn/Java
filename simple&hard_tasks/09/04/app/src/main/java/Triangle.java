public class Triangle extends Polygon implements Printable {
    private double aSide;
    private double bSide;
    private double cSide;

    public Triangle(double aSide, double bSide, double cSide) {
        super(3);
        this.aSide = aSide;
        this.bSide = bSide;
        this.cSide = cSide;
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Треугольник{" +
                "число углов=" + angleCount +
                ", сторона a=" + aSide +
                ", сторона b=" + bSide +
                ", сторона c=" + cSide +
                '}';
    }
}
