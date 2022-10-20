public class Polygon implements Printable {
    protected int angleCount;

    public Polygon(int angleCount) {
        this.angleCount = angleCount; //кол-во углов
    }

    @Override
    public String toString() {
        return "Многоугольник{" +
                "число углов=" + angleCount +
                '}';
    }

    @Override
    public void print() {
        System.out.println(this);
    }
}
