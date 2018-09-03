/**
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element. You may assume no duplicate exists in the array.
 *
 */

public class FindMinInRotatedSortedArrayLeetCode {

    //Binary search modification.
    public static int findMin(int[] nums) {
        int low=0, high =nums.length-1;
        while(low<high){
            int mid = low + (high-low)/2;
            int midVal=nums[mid], lowVal=nums[low], highVal=nums[high];
            if(midVal>highVal)
                low = mid+1;
            else
                high = mid;
        }
        return nums[low];
    }

    public static void main(String args[]){
        int nums[]={ 1};
        System.out.print(findMin(nums));
    }
}
