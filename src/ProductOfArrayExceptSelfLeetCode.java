/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */

import java.util.Arrays;

public class ProductOfArrayExceptSelfLeetCode {

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0]= 1;
        int prod=1;
        for(int i=0;i<nums.length-1;i++){
            prod*=nums[i];
            result[i+1] = prod;
        }
        prod=1;
        for(int i=nums.length-1;i>0;i--){
            prod*=nums[i];
            result[i-1] = prod*result[i-1];
        }
        return result;
    }

    public static void main(String args[]){
        int[] prods = productExceptSelf(new int[]{1,2,3,4});
        System.out.println(Arrays.toString(prods));
    }

}
