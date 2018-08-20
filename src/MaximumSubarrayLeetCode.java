/**
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 */
public class MaximumSubarrayLeetCode {

    //Dynamic programming. Bottom up.
    public static int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        int[] dp= new int[nums.length];
        int result = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(i==0) dp[i]=nums[i];
            else
                dp[i] = Math.max(nums[i],nums[i]+dp[i-1]);
            result = Math.max(result,dp[i]);
        }
        return result;
    }

    public static void main(String args[]) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.print(maxSubArray(nums));
    }
}
