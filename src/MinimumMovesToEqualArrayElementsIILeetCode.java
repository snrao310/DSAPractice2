/**
 *
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a
 * move is incrementing a selected element by 1 or decrementing a selected element by 1.
 *
 * You may assume the array's length is at most 10,000.
 *
 * Example:
 * Input:
 * [1,2,3]
 * Output:
 * 2
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 *
 */
public class MinimumMovesToEqualArrayElementsIILeetCode {

    public static int minMoves2(int[] nums) {
        int median = getKthElement(nums,0,nums.length-1, nums.length/2), result=0;
        for(int i=0;i<nums.length;i++){
            result += Math.abs(median - nums[i]);
        }
        return result;
    }

    //quickselect
    private static int getKthElement(int[] nums,int start, int end, int k){
        int pivotIndex = start + (int) (Math.random()*(end-start+1));
        pivotIndex = partition(nums,start,end,pivotIndex);
        if(pivotIndex == start+k)
            return nums[pivotIndex];
        if(pivotIndex > start + k)
            return getKthElement(nums, start, pivotIndex-1, k);
        else
            return getKthElement(nums, pivotIndex+1, end, k-(pivotIndex-start+1));
    }

    private static int partition(int[] nums, int start, int end,int pivotIndex){
        swap(nums,start,pivotIndex);
        int split = start+1;
        for(int i=start+1;i<=end;i++){
            if(nums[i]<nums[start]){
                swap(nums,split,i);
                split++;
            }
        }
        swap(nums, start,split-1);
        return split-1;
    }

    private static void swap(int[] nums, int i, int j){
        int tem=nums[i];
        nums[i]=nums[j];
        nums[j]=tem;
    }


    public static void main(String[] args) {
        System.out.println(minMoves2(new int[]{1,0,0,8,6}));
    }

}
