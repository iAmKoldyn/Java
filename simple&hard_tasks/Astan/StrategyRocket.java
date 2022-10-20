public class StrategyRocket extends Rocket {

    private final int MIN_DISTANCE = 10000;
    private final int MAX_DISTANCE = 40000;

    public StrategyRocket() {

    }

    @Override
    public boolean fire(int targetDistance) {
        return (targetDistance - calcDistance(MIN_DISTANCE, MAX_DISTANCE)) < 0;
    }

    @Override
    public String toString() {
        return "StrategyRocket{" +
                "MIN_DISTANCE=" + MIN_DISTANCE +
                ", MAX_DISTANCE=" + MAX_DISTANCE +
                '}';
    }
}
