/**
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 *
 */
public class MaximalSquareLeetCode {


    public static int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        int result=0,n=matrix.length,m=matrix[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='0')continue;
                dp[i][j]=1;
                if(i!=0 && j!=0 && dp[i-1][j]!=0 && dp[i][j-1]!=0)
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                result=Math.max(result,dp[i][j]);
            }
        }
        return result*result;
    }

    public static void main(String args[]){
        System.out.print(maximalSquare(new char[][]{{'1','0','1','0'},{'1','0','1','1'},{'1','0','1','1'},{'1','1','1','1'}}));
    }
}
