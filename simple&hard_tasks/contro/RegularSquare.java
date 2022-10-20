public class RegularSquare extends RegularFigure {
    RegularSquare(double sideLength) {
        this.sideLength = sideLength;
        this.sideCount = 4;
    }

    @Override
    public String toString() {
        return "Regular Square: " + sideLength;
    }
}
