
/**
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last
 * index.)
 *
 * Note:
 * You can assume that you can always reach the last index.
 *
 */
public class JumpGameIILeetCode {

    //O(n) time and space.
    public static int jumpdp(int[] nums) {
        int[] dp=new int[nums.length];
        for(int i=0,j=1;i<nums.length && j<nums.length;i++){
            int val=nums[i];
            while(j<nums.length && j<=i+val)
                dp[j++]=dp[i]+1;
        }
        return dp[nums.length-1];
    }

    //O(n) time and constant space.
    public static int jump(int[] nums) {
        if(nums.length<2) return 0;
        int maxInd=0, lastJumpMax=0, jumps=0;
        for(int i=0;i<nums.length;i++){
            if(i>lastJumpMax){
                lastJumpMax=maxInd;
                jumps++;
            }
            maxInd=Math.max(maxInd,i+nums[i]);
        }
        return jumps;
    }

    public static void main(String args[]){
        System.out.print(jump(new int[]{2,3,1,1,4}));
    }
}
