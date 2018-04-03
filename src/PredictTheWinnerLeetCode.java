import java.util.Arrays;

/**
 *
 * Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the
 * array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not
 * be available for the next player. This continues until all the scores have been chosen. The player with the maximum
 * score wins.
 *
 * Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his
 * score.
 *
 * Example 1:
 * Input: [1, 5, 2]
 * Output: False
 * Explanation: Initially, player 1 can choose between 1 and 2.
 * If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be
 * left with 1 (or 2).
 * So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
 * Hence, player 1 will never be the winner and you need to return False.
 *
 * Example 2:
 * Input: [1, 5, 233, 7]
 * Output: True
 * Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2
 * choose, player 1 can choose 233.
 * Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
 *
 * Note:
 * 1 <= length of the array <= 20.
 * Any scores in the given array are non-negative integers and will not exceed 10,000,000.
 * If the scores of both players are equal, then player 1 is still the winner.
 *
 */

public class PredictTheWinnerLeetCode {

    public static boolean PredictTheWinner(int[] nums) {
        int len=nums.length, sum=0, dp[][] = new int[len][len];
        for (int i=0;i<len;i++)
            Arrays.fill(dp[i],-1);
        for(int i=0;i<len-1;i++){
            dp[i][i]=nums[i];
            dp[i][i+1]=Math.max(nums[i],nums[i+1]);
            sum+=nums[i];
        }
        dp[len-1][len-1]=nums[len-1];
        sum+=nums[len-1];
        if(sum==0) return true;
        return canWin(0,len-1,nums,dp,sum);
    }

    private static boolean canWin(int start, int end, int[] nums, int[][] dp, int sum){
        if(start>end) return false;
        if(dp[start][end]!=-1)
            return (dp[start][end]>=Math.ceil(sum/2.0));
        if(end==start+1){
            dp[start][end]=Math.max(nums[start],nums[end]);
            return (dp[start][end]>=Math.ceil(sum/2.0));
        }
        else{
            canWin(start+1, end,nums, dp,sum-nums[start]);
            canWin(start, end-1, nums, dp, sum-nums[end]);
            int first = sum - dp[start+1][end];
            int last = sum - dp[start][end-1];
            dp[start][end] = Math.max(first, last);
            return (dp[start][end]>=Math.ceil(sum/2.0));
        }
    }

    public static void main(String args[]){
        System.out.println(PredictTheWinner(new int[]{1,3,1}));
        System.out.println(PredictTheWinner(new int[]{1,5,233,7}));
    }
}
