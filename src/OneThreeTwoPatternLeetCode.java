import java.util.Stack;

/**
 * Created by S N Rao on 1/11/2017.
 *
 *
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k
 * and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern
 * in the list.
 * Note: n will be less than 15,000.
 *
 */

public class OneThreeTwoPatternLeetCode {

    public static boolean find132pattern(int[] nums) {
        if(nums.length==0) return false;
        int[] prevMin = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            prevMin[i]=(i==0)?nums[i]:Math.min(prevMin[i-1],nums[i]);
        }
        Stack<Integer> prevGreater = new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            while(!prevGreater.isEmpty() && prevGreater.peek()<nums[i]){
                if(prevMin[i] < nums[i] && prevMin[i] < prevGreater.peek())
                    return true;
                prevGreater.pop();
            }
            prevGreater.push(nums[i]);
        }
        return false;
    }

    public static void main(String args[]){
        System.out.print(find132pattern(new int[]{1,0,1,-4,-3}));
    }

}
