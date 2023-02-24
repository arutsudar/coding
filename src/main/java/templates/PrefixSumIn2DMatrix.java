package templates;

/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 *
 * Given a 2D matrix matrix, handle multiple queries of the following type:
 *
 * Calculate the sum of the elements of matrix inside the rectangle defined by
 *      its upper left corner (row1, col1) and lower right corner (row2, col2).
 * Implement the NumMatrix class:
 *
 * NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
 * int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle
 *      defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 */
class PrefixSumIn2DMatrix {

    private int[][] prefixSum;

    public PrefixSumIn2DMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        prefixSum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                prefixSum[r + 1][c + 1] = prefixSum[r + 1][c] + prefixSum[r][c + 1] + matrix[r][c] - prefixSum[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row2 + 1][col2 + 1] - prefixSum[row1][col2 + 1] - prefixSum[row2 + 1][col1] + prefixSum[row1][col1];
    }

}

//class PrefixSumIn2DMatrix {
//
//    int[][] prefixSum;
//
//    public PrefixSumIn2DMatrix(int[][] matrix) {
//        int n = matrix.length;
//        int m = matrix[0].length;
//        prefixSum = new int[n][m];
//        for (int i=0; i<n; i++)
//            for (int j=0; j<m; j++)
//                if (i-1 >= 0 && j-1 >= 0)
//                    prefixSum[i][j] = prefixSum[i][j-1] + prefixSum[i-1][j] - prefixSum[i-1][j-1] + matrix[i][j];
//                else if (i-1 >= 0)
//                    prefixSum[i][j] = prefixSum[i-1][j] + matrix[i][j];
//                else if (j-1 >= 0)
//                    prefixSum[i][j] = prefixSum[i][j-1] + matrix[i][j];
//                else
//                    prefixSum[i][j] = matrix[i][j];
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        if (row1-1 >= 0 && col1-1 >= 0)
//            return prefixSum[row2][col2] - prefixSum[row1-1][col2] - prefixSum[row2][col1-1] + prefixSum[row1-1][col1-1];
//        else if (row1-1 >= 0)
//            return prefixSum[row2][col2] - prefixSum[row1-1][col2];
//        else if (col1-1 >= 0)
//            return prefixSum[row2][col2] - prefixSum[row2][col1-1];
//        else
//            return prefixSum[row2][col2];
//    }
//}
