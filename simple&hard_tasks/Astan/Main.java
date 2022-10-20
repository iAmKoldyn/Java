import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int targetDistance;
        System.out.println("Input target distance");
        targetDistance = new Scanner(System.in).nextInt();
        Rocket[] rockets = {
                new TacticalRocket(),
                new StrategyRocket(),
                new TacticalRocket(),
                new OperativeRocket(),
                new StrategyRocket(),
                new TacticalRocket(),
                new OperativeRocket()
        };
        for (Rocket rocket : rockets) {
            System.out.println(rocket + " удар: " + (rocket.fire(targetDistance) ? "успешно" : "не долёт"));
        }
    }
}