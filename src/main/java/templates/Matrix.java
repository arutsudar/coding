
/**
 * Matrix Exponentiation and Matrix Multiplication Utilities
 */
class MatrixUtils {

    public static long[][] multiply(long[][] A, long[][] B, int mod) {
        int n = A.length;
        long[][] C = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) { // k-loop moved up for cache efficiency
                if (A[i][k] == 0) continue;
                for (int j = 0; j < n; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % mod;
                }
            }
        }
        return C;
    }

    public static long[][] power(long[][] A, int p, int mod) {
        int n = A.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) res[i][i] = 1; // Identity matrix
        
        long[][] base = A;
        while (p > 0) {
            if ((p & 1) == 1) res = multiply(res, base, mod);
            base = multiply(base, base, mod);
            p >>= 1;
        }
        return res;
    }

    public static void printMatrix(long[][] matrix) {
        for (long[] row : matrix) {
            for (long val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

}