/**
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 */
public class BestTimeToBuySellStockIIILeetCode {


    //dp solution. dp[i]=maxProfit in subArray from 0 to i buying and selling only once.
    //come backward and find maxprofit in subArray from i to prices.length-1 for each i and use dp to find out
    //maxpProfit by selling twice.
    //This is good. O(n) time and O(n) space. Most hard working coders will submit this.
    //But check out the next solution. This is Ronaldo. The next one is Messi.
    public static int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int[] dp=new int[prices.length];
        int profit = 0,min=prices[0],max=prices[prices.length-1],res=0;
        for(int i=0;i<prices.length;i++){
            min=Math.min(min,prices[i]);
            profit=Math.max(profit,prices[i]-min);
            dp[i]=profit;
        }

        profit=0; res=dp[dp.length-1];
        for(int i=prices.length-1;i>=0;i--){
            max=Math.max(max,prices[i]);
            profit=Math.max(profit,max-prices[i]);
            if(i!=0) res=Math.max(res,profit+dp[i-1]);
        }
        return res;
    }

    //O(n) time and constant space. Just maintain 4 variables.
    public static int maxProfitBest(int[] prices) {
        int hold1=Integer.MIN_VALUE, hold2=Integer.MIN_VALUE, release1=0, release2=0;
        for(int i: prices){                         //Assume we only have 0 money at first
            release2=Math.max(release2,hold2+i);    // The maximum if we've just sold 2nd stock so far.
            hold2=Math.max(hold2,release1-i);       // The maximum if we just buy 2nd stock so far.
            release1=Math.max(release1,hold1+i);    // The maximum if we've just sold 1st stock so far.
            hold1=Math.max(hold1,-i);               // The maximum if we just buy 1st stock so far.
        }
        return release2;
    }

    public static void main(String args[]){
        System.out.print(maxProfit(new int[]{1,0,0,1,3,2,8,5,7,6}));
    }
}
