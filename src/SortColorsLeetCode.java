import java.util.Arrays;

/**
 *
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 *
 */
public class SortColorsLeetCode {

    public static void sortColors(int[] nums) {
        int zeroEnd=-1,oneEnd=-1,twoEnd=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                swap(nums,oneEnd+1,i);
                swap(nums,zeroEnd+1,oneEnd+1);
                zeroEnd++; oneEnd++; twoEnd++;
            }
            else if(nums[i]==1){
                swap(nums,oneEnd+1,i);
                oneEnd++; twoEnd++;
            }
            else
                twoEnd++;
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String args[]){
        int[] nums = {2,1,1,2,0,1,2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{0,1,2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
