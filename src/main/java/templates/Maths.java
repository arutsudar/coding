package templates;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Maths {

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static long lcm(long a, long b) {
        long GCD = gcd(a, b);
        return (a * b) / GCD;
    }

    private static long lcmOfArray(long[] arr, int idx) {
        // lcm(a,b) = (a*b/gcd(a,b))
        if (idx == arr.length - 1) {
            return arr[idx];
        }
        long a = arr[idx];
        long b = lcmOfArray(arr, idx+1);
        return ( a*b / gcd(a,b) );
    }

    private static String sumOf2VeryLargeNos(String num1, String num2) {
        BigInteger bigInt1 = new BigInteger(num1);
        BigInteger bigInt2 = new BigInteger(num2);
        return bigInt1.add(bigInt2).toString();
    }

    private static String differenceOf2VeryLargeNos(String num1, String num2) {
        BigInteger bigInt1 = new BigInteger(num1);
        BigInteger bigInt2 = new BigInteger(num2);
        return bigInt1.subtract(bigInt2).toString();
    }

    private static List<Integer> getDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i=1; i<=Math.sqrt(n); i++) {
            if (n%i==0) {
                if (n/i == i) {
                    divisors.add(i);
                } else {
                    divisors.add(i);
                    divisors.add(n/i);
                }
            }
        }
        return divisors;
    }

}
