// Helper class for Modular arithmetic
// https://leetcode.com/contest/biweekly-contest-157/problems/number-of-ways-to-assign-edge-weights-i/submissions/1643202100/
public class ModularArithmeticLong {

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static long modInverse(long b, long m){
        long g = gcd(b, m) ;
        if (g != 1)
            return -1;
        else {
            return power(b, m-2, m);
        }
    }

    public static long modDivide(long a, long b, long mod) {
        a = a % mod;
        long inv = modInverse(b,mod);
        if (inv == -1) {
            throw new RuntimeException("Division not defined");
        }
        else {
            return ((inv*a) % mod);
        }
    }

    public static long power(long a, long b, long mod) {
        long res = 1;
        a = a % mod;
        if (a == 0)
            return 0;
        while (b > 0) {
            if ((b & 1) != 0)
                res = (res * a) % mod;
            b = b >> 1; // b = b/2
            a = (a * a) % mod;
        }
        return res;
    }

}