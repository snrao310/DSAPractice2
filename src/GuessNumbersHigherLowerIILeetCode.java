import java.util.Arrays;

/**
 *
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you
 * guess the number I picked.
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 *
 */

//Min max problems: Minimize maximum loss. i.e. find best move considering worst case feedback for
// each move you make.
public class GuessNumbersHigherLowerIILeetCode {

    public static int getMoneyAmount(int n) {
        if(n==1) return 0;
        int dp[][] = new int[n+1][n+1];
        for(int[] arr: dp)
            Arrays.fill(arr,-1);
        return topDownDP(1,n,dp);
    }

    private static int topDownDP(int start,int end,int[][] dp){
        if(start >= end)
            return 0;
        if(dp[start][end]!=-1)
            return dp[start][end];

        int min = Integer.MAX_VALUE;
        for(int i=start;i<=end;i++){
            int left = topDownDP(start,i-1,dp);
            int right = topDownDP(i+1, end, dp);
            int result = Math.max(left+i, right+i); //Fate always is not in your favor. Bad feedback to every move you make
            min = Math.min(min,result);             //Select the move with minimum bad feedback.
        }
        dp[start][end] = min;
        return min;
    }

    public static void main(String args[]){
        System.out.println(getMoneyAmount(4));
    }

}
