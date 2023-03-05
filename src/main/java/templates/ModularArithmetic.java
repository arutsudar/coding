package templates;

/**
 * Modular arithmetic
 * 	• Addition:
 * 		(a + b) mod m = ((a mod m) + (b mod m)) mod m
 * 	• Subtraction:
 * 		(a - b) mod m = (((a mod m) - (b mod m)) + m) mod m
 * 	• Multiplication:
 * 		(a x b) mod m = ((a mod m) x (b mod m)) mod m
 * 	• Division:
 * 		( a / b ) % m = ( a % m ) * ( ( 1 / b ) % m ) = ( a % m ) * ( ( b ^ ( m — 2 ) ) % m )
 *      Note: Modular inverse of a mod m exists only if a and m are relatively prime i.e. gcd(a, m) = 1.
 */
public class ModularArithmetic {

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * (a ^ b) % mod
     * It returns -1 when inverse doesn't exist
     * modInverse works for prime m
     */
    private static int modInverse(int b, int m){
        int g = gcd(b, m) ;
        if (g != 1)
            return -1;
        else {
            // If b and m are relatively prime,
            // then modulo inverse is b^(m-2) mod m
            return power(b, m-2, m);
        }
    }

    /**
     * (a / b) % mod
     * Source: https://www.geeksforgeeks.org/modular-division/
     */
    public static int modDivide(int a, int b, int mod) {
        a = a % mod;
        int inv = modInverse(b,mod);
        if(inv == -1) {
            throw new RuntimeException("Division not defined");
        }
        else {
            return ((inv*a) % mod);
        }
    }

    /**
     * (a ^ b) % mod
     * Modular exponentiation in O(log b) time
     *
     * Source: https://www.geeksforgeeks.org/modular-exponentiation-power-in-modular-arithmetic/
     */
    public static int power(long a, long b, int mod) {
        long res = 1;
        a = a % mod; // Update a if it is more than or equal to mod
        if (a == 0)
            return 0; // In case a is divisible by mod;
        while (b > 0) {
            // If b is odd, multiply a with result
            if ((b & 1) != 0)
                res = (res * a) % mod;
            // b must be even now
            b = b >> 1; // b = b/2
            a = (a * a) % mod;
        }
        return (int) res;
    }

}
