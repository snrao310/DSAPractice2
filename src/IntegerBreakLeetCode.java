/*
Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: You may assume that n is not less than 2 and not larger than 58.
 */

import java.util.Arrays;

public class IntegerBreakLeetCode {

    public static int integerBreak(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;dp[1] = 1; dp[2]=1;
        return integerBreakDP(n,dp);
    }

    private static int integerBreakDP(int n, int[] dp){
        if(dp[n]!=-1) return dp[n];
        for(int i=1;i<n;i++){
            int p= Math.max(i,integerBreakDP(i,dp))*(Math.max((n-i),integerBreakDP(n-i,dp)));
            dp[n] = Math.max(dp[n],p);
        }
        return dp[n];
    }

    public static void main(String args[]){
        System.out.println(integerBreak(6));
    }
}
