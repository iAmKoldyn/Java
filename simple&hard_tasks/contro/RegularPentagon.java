public class RegularPentagon  extends RegularFigure{
    public RegularPentagon(double sideLength) {
        this.sideCount = 5;
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        return "Regular pentagon: " + sideLength;
    }
}
