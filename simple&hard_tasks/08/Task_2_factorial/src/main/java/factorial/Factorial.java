package factorial;

import java.math.BigInteger;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(getFactorial(38));// BPM
    }

    public static BigInteger getFactorial(int factorial) {// MBOZF
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i <= factorial; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }
}
