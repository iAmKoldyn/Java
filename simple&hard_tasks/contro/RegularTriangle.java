public class RegularTriangle extends RegularFigure {

    //также
    private final String BOTTOM_SIDE =  "\n*\t\t*";
    private final String APEX = "\t*\t";

    public RegularTriangle(double sideLength) {
        this.sideLength = sideLength;
        this.sideCount = 3;
    }

    @Override
    public String toString() {
        String triangle = APEX;
        triangle += "Triangle with area: " + calcArea();
        triangle += BOTTOM_SIDE;
        return triangle;
    }
}
