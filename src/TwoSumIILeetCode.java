/**
 *
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a
 * specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must
 * be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 */
public class TwoSumIILeetCode {

    public static int[] twoSumSorted(int[] numbers, int target) {
        int l=0, h=numbers.length-1;
        while(l<h){
            int curSum=numbers[l]+numbers[h];
            if(curSum==target) return new int[]{l+1,h+1};
            if(curSum<target)l++;
            else h--;
        }
        return new int[]{};
    }

    public static void main(String args[]) {
        int numbers[]={2, 7, 11, 15};
        twoSumSorted(numbers, 9); //No extra space
    }
}
