import java.util.Random;

public abstract class Rocket {


    protected int calcDistance(int minDistance, int maxDistance) {
        return new Random().nextInt(minDistance) + (maxDistance -  minDistance);
    }
    abstract public boolean fire(int targetDistance);

    @Override
    public String toString() {
        return super.toString();
    }
}
