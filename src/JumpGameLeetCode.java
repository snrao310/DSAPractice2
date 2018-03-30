/**
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 *
 */
public class JumpGameLeetCode {

    public static boolean canJump(int[] nums) {
        int maxReach=0;
        for(int i=0;i<=maxReach;i++){
            maxReach=Math.max(maxReach,i+nums[i]);
            if(maxReach>=nums.length-1)
                return true;
        }
        return false;
    }

    public static void main(String args[]){
        System.out.print(canJump(new int[]{2,3,1,1,4}));
    }
}
