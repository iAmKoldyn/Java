public class TacticalRocket extends Rocket {
    private final int MIN_DISTANCE = 1;
    private final int MAX_DISTANCE = 500000;

    @Override
    public boolean fire(int targetDistance) {
        return (targetDistance - calcDistance(MIN_DISTANCE, MAX_DISTANCE)) < 0;
    }

    @Override
    public String toString() {
        return "TacticalRocket{" +
                "MIN_DISTANCE=" + MIN_DISTANCE +
                ", MAX_DISTANCE=" + MAX_DISTANCE +
                '}';
    }
}
