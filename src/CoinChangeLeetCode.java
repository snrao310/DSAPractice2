import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the
 * fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 *
 *
 */
public class CoinChangeLeetCode {

    //DP. Top-down is better because amount may be big and filling all values before it may not be the best idea.
    // But still implementing bottom-up coz of ease.
    public static int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int dp[]=new int[amount+1];
        Arrays.fill(dp,-1);
        for(int i=1;i<amount+1;i++){
            for(int j=0;j<coins.length;j++){
                if(i<coins[j])continue;
                if(i==coins[j])dp[i]=1;
                if(dp[i-coins[j]]==-1) continue;
                if(dp[i]==-1)dp[i]=Integer.MAX_VALUE;
                dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
            }
        }
        return dp[amount];
    }

    public static void main(String args[]){
        System.out.println(coinChange(new int[]{25,7,10},109));
    }

}
