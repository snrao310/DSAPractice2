import java.util.Stack;

/**
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 *
 * Example 1:
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 *
 * Example 2:
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 *
 * Example 3:
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 *
 **/


public class RemoveKDigitsLeetCode {

    public static String removeKdigits(String num, int k) {
        if(k==0) return num;
        if(k>=num.length()) return "0";
        int count=0, startZeroes=0;
        StringBuilder sb= new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        stack.push(Character.getNumericValue(num.charAt(0)));
        for(int i=1;i<num.length();i++){
            if(stack.isEmpty() || stack.peek() <= Character.getNumericValue(num.charAt(i)) || count==k)
                stack.push(Character.getNumericValue(num.charAt(i)));
            else{
                stack.pop();
                count++;
                i--;
            }
        }
        while(!stack.isEmpty()) sb.insert(0,stack.pop());
        sb=new StringBuilder(sb.substring(0,num.length()-k));
        while(sb.length()!=0 && sb.charAt(0)=='0') sb.deleteCharAt(0);
        if(sb.length()==0) return "0";
        return sb.toString();
    }

    public static void main(String args[]){
        System.out.println(removeKdigits("112",1));
        System.out.println(removeKdigits("10200",1));
        System.out.println(removeKdigits("10",2));
        System.out.println(removeKdigits("1234567890",9));
    }
}
