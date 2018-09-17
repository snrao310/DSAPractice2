/**
 *
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 *
 */
public class NextPermutationLeetCode {

    //Same thing as NextGreaterElementIIILeetCode. Find the last peak in the array in number and swap the number before
    //the peak with the smallest number after the peak [number that would comes after the (number before peak) in sorted
    //array of these elements]. Then, reverse everything from this last peak to the end of array. That's it. O(n) time.
    public static void nextPermutation(int[] nums) {
        if(nums.length==0 || nums.length==1) return;
        int i;
        for(i=nums.length-1;i>0;i--){
            if(nums[i-1]<nums[i])
                break;
        }
        if(i!=0){
            int j=findJustGreater(nums,i,nums.length-1,nums[i-1]);
            swap(nums,i-1,j);
        }
        reverse(nums,i,nums.length-1);
    }

    private static void swap(int[] nums, int i, int j){
        int temp=nums[i]; nums[i]=nums[j]; nums[j]=temp;
    }

    private static int findJustGreater(int[] nums, int start, int end, int value){
        int maxInd=-1,max=Integer.MAX_VALUE;
        for(int i=start;i<=end;i++){
            if(nums[i]>value && nums[i]<=max){
                max=nums[i]; maxInd=i;
            }
        }
        return maxInd;
    }

    private static void reverse(int[] nums, int start, int end){
        while(start<end)
            swap(nums,start++,end--);
    }

    public static void main(String args[]){
        int nums[]={2,3,1,3,3};
        nextPermutation(nums);
        for(int i: nums){
            System.out.print(i+" ");
        }
    }
}
