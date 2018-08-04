/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumLeetCode {

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(indexMap.containsKey(target-nums[i])){
                res[0]=indexMap.get(target-nums[i]);
                res[1]=i;
                break;
            }
            else{
                indexMap.put(nums[i],i);
            }
        }
        return res;
    }

    public static void main(String args[]){
        int[] res = twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(Arrays.toString(res));
    }
}
