import java.util.Random;

/**
 *Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 *
 */
public class KthLargestElementInAnArrayLeetCode {

    public static int findKthLargest(int[] nums, int k) {
        return findKthSmallest(nums,0,nums.length-1,nums.length-k);
    }

    private static int findKthSmallest(int[] nums, int start, int end, int k){
        if(start<0 || end==nums.length || start>end) return -1;
        int len = end-start+1;
        int randInd=start+(int)(Math.random()*len);
        int pivotInd = partitionAroundPivot(nums,randInd,start,end);
        if(pivotInd==(k+start)) return nums[pivotInd];
        if(pivotInd<(k+start)) return findKthSmallest(nums,pivotInd+1,end,(k+start)-pivotInd-1);
        else return findKthSmallest(nums,start,pivotInd-1,k);
    }

    private static int partitionAroundPivot(int[] nums,int pivotInd,int start, int end){
        int pivotVal=nums[pivotInd], i=start+1;
        swap(nums,start,pivotInd);
        for(int j=start+1;j<=end;j++){
            if(nums[j]<pivotVal){
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,i-1,start);
        return i-1;
    }

    private static void swap(int[] nums,int i, int j){
        int temp = nums[i]; nums[i] = nums[j]; nums[j] = temp;
    }


    public static void main(String args[]){
        System.out.print(findKthLargest(new int[]{1,2,3,4,5,6}, 4));
    }
}
