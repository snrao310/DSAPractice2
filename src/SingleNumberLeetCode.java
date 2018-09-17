/**
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class SingleNumberLeetCode {

    public static int singleNumber(int[] nums) {
        int res=0;
        for(int i: nums) res^=i;
        return res;
    }

    public static void main(String args[]){
        int input1[]={2,3,2,4,3,6,7,7,6};

        int result1=singleNumber(input1);
        System.out.println(result1);
    }
}
