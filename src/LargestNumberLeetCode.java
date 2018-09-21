import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 */
public class LargestNumberLeetCode {

    public static String largestNumber(int[] nums) {
        Comparator<String> comp=new Comparator<String>(){
            @Override
            public int compare(String o1String, String o2String){
                char[] o1=o1String.toCharArray(), o2=o2String.toCharArray();
                int o1Ind=0, o2Ind=0;
                while(o1Ind<o1.length || o2Ind<o2.length){
                    if(o1Ind==o1.length) o1Ind=0;
                    if(o2Ind==o2.length) o2Ind=0;
                    if(o1[o1Ind] > o2[o2Ind]) return -1;
                    else if(o1[o1Ind] < o2[o2Ind]) return 1;
                    else{
                        o1Ind++; o2Ind++;
                    }
                }
                return 1;
            }
        };

        boolean allZeroes=true;
        for(int i:nums) if(i!=0) allZeroes=false;
        if(allZeroes) return "0";
        String[] numStrings=new String[nums.length];
        int i=0;
        for(int num: nums) numStrings[i++]=Integer.toString(num);
        Arrays.sort(numStrings,comp);
        StringBuilder sb=new StringBuilder();
        for(String num: numStrings) sb.append(num);
        return sb.toString();
    }

    public static void main(String args[]){
        System.out.print(largestNumber(new int[]{0,0,1}));
    }
}
