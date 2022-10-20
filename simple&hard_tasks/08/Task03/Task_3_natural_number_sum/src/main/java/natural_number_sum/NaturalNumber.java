package natural_number_sum;

public class NaturalNumber {

    public static void main(String[] args) {
        System.out.println(getNaturalNumberSum(5));
    }

    public static long getNaturalNumberSum(long number) {// МCHЧ
        return (number * (number + 1) / 2);
    }
}
