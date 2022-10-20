public class OperativeRocket extends Rocket {
    private final int MIN_DISTANCE = 500;
    private final int MAX_DISTANCE = 10000;

    @Override
    public boolean fire(int targetDistance) {
        return (targetDistance - calcDistance(MIN_DISTANCE, MAX_DISTANCE)) < 0;
    }

    @Override
    public String toString() {
        return "OperativeRocket{" +
                "MIN_DISTANCE=" + MIN_DISTANCE +
                ", MAX_DISTANCE=" + MAX_DISTANCE +
                '}';
    }
}
