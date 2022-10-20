package factorial;

import java.math.BigInteger;

public class RecursiveFactorial {
    public static void main(String[] args) {
        System.out.println(getFactorial(2147483647));// BzPM
    }

    public static BigInteger getFactorial(int factorial) {// PM
        if (factorial <= 1) {
            return BigInteger.valueOf(1);
        }
        else {
            return BigInteger.valueOf(factorial).multiply(getFactorial(factorial - 1));// PB
        }
    }
}
