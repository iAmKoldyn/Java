public abstract class RegularFigure implements Figure  {
    protected int sideCount;
    protected double sideLength;

    //формула площади правильного sideCount угольника
    @Override
    public double calcArea() {
        double firstMultiplier = (sideCount * sideLength * sideLength)/4;
        double secondMultiplier = 1.0 / Math.tan(Math.PI / sideCount);
        return firstMultiplier * secondMultiplier;
    }
}
