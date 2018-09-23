/**
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 */
public class ClimbingStairsLeetCode {

    public static int climbStairs(int n) {
        int prev=2, prev2=1;
        if(n<3) return n;
        for(int i=3; i<=n;i++){
            int cur=prev+prev2;
            prev2=prev; prev=cur;
        }
        return prev;
    }

    public static void main(String args[]){
        System.out.print(climbStairs(6)); //13
    }
}
