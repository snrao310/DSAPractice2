/**
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 *
 */
public class SearchInRotatedSortedArrayLeetCode {

    public static int search(int[] nums, int target) {
        int len = nums.length, mid, high=len-1, low=0;
        while(low<=high){
            mid = (low+high)/2;
            int midVal= nums[mid], highVal = nums[high], lowVal=nums[low];
            if(midVal==target) return mid;
            if(midVal>=lowVal){
                if(midVal>target && lowVal<=target)
                    high=mid-1;
                else
                    low=mid+1;
            }
            else{
                if(midVal<target && highVal>=target)
                    low=mid+1;
                else
                    high =mid-1;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        System.out.println(search(new int[]{5,1,3},2));
    }
}
