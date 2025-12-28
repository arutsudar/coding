
// Tested on https://leetcode.com/problems/count-the-number-of-arrays-with-k-matching-adjacent-elements/submissions/1667472477/?envType=daily-question&envId=2025-06-17

import java.util.*;

private class FastCombinations {

    static final int MAX = 100000;
    static long[] fact = new long[MAX + 1];
    static long[] invFact = new long[MAX + 1];

    static void facts() {
        fact[0] = invFact[0] = 1;
        for (int i = 1; i <= MAX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
            invFact[i] = power(fact[i], MOD - 2, MOD);
        }
    }

    static long power(long base, long exp, long mod) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }

    static long nCr(int n, int r) {
        if (r > n) return 0;
        return (fact[n] * invFact[r] % MOD * invFact[n - r] % MOD) % MOD;
    }

    // Got TLE on https://leetcode.com/contest/biweekly-contest-157/problems/number-of-ways-to-assign-edge-weights-i/
    public static void init(String[] args) {
        facts(); // Precompute values
    }

}
