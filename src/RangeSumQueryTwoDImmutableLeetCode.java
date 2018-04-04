/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner
 * (row1, col1) and lower right corner (row2, col2).
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 * <p>
 * Example:
 * Given matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * <p>
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * <p>
 * Note:
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class RangeSumQueryTwoDImmutableLeetCode {

    public static class NumMatrix {

        //dp[i][j] = sum of all elements in box with left top corner (0,0) and right bottom corner (i,j).
        int[][] dp;

        public NumMatrix(int[][] matrix) {
            if(matrix.length==0) return;
            dp = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    int sumUp = (i != 0) ? dp[i - 1][j] : 0;
                    int sumLeft = (j != 0) ? dp[i][j - 1] : 0;
                    int sumUpLeft = (i != 0 && j != 0) ? dp[i - 1][j - 1] : 0;
                    dp[i][j] = matrix[i][j] + sumUp + sumLeft - sumUpLeft;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sumUp = (row1 != 0) ? dp[row1 - 1][col2] : 0;
            int sumLeft = (col1 != 0) ? dp[row2][col1 - 1] : 0;
            int sumUpLeft = (row1 != 0 && col1 != 0) ? dp[row1 - 1][col1 - 1] : 0;
            return dp[row2][col2] - sumUp - sumLeft + sumUpLeft;
        }
    }

    public static void main(String args[]) {
        /**
         * Your NumMatrix object will be instantiated and called as such:
         * NumMatrix obj = new NumMatrix(matrix);
         * int param_1 = obj.sumRegion(row1,col1,row2,col2);
         */
        NumMatrix obj = new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
        System.out.println(obj.sumRegion(2, 1, 4, 3));
        System.out.println(obj.sumRegion(1, 1, 2, 2));
        System.out.println(obj.sumRegion(1, 2, 2, 4));
    }
}
