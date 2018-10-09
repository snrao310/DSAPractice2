/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 */
public class UniqueBinarySearchTreesLeetCode {

    public static int numTrees(int n) {
        if(n==0 || n==1) return 1;
        int[] dp=new int[n+1];
        return recursiveFunction(n,dp);
    }

    private static int recursiveFunction(int n, int[] dp){
        if(n==0 || n==1) return 1;
        if(dp[n]!=0) return dp[n];
        int res=0, k=n-1;
        for(int i=0;i<=k;i++){
            res+=(recursiveFunction(i,dp)*recursiveFunction(k-i,dp));
        }
        dp[n]=res;
        return res;
    }

    public static void main(String args[]){
        System.out.print(numTrees(3));
    }
}
