import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in
 * the array which gives the sum of zero.
 */
public class ThreeSumLeetCode {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            int target = (-nums[i]);
            int low=i+1, high=nums.length-1;
            while(low<high){
                int lowVal=nums[low], highVal=nums[high];
                if(lowVal+highVal==target)
                    result.add(Arrays.asList(nums[i],lowVal,highVal));
                if(lowVal+highVal < target)
                    while(low<nums.length && nums[low]==lowVal) low++;
                else
                    while(high>=0 && nums[high]==highVal) high--;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int[] arr = {1,-1,-1,0};
        List<List<Integer>> k = threeSum(arr);
        for (List<Integer> l : k) {
            for (Integer m : l)
                System.out.print(m + " ");
            System.out.println();
        }

    }
}
