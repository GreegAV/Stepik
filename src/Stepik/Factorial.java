package Stepik;

import java.math.BigInteger;

/**
 * Calculates factorial of given <code>value</code>.
 *
 * @param value positive number
 * @return factorial of <code>value</code>
 */

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(10));
    }
    public static BigInteger factorial(int value) {
        BigInteger ret = BigInteger.ONE;
        for (int i = 1; i <= value; ++i) ret = ret.multiply(BigInteger.valueOf(i));
        return ret;
    }

}

