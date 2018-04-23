/**
 * Created by S N Rao on 1/16/2017.
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 *
 * Example 1:
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 *
 * Example 2:
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 * Note:
 *
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 */

public class MultiplyStringsLeetCode {

    //general rule: product of numbers with m digits and n digits can have maximum m+n digits.
    public static String multiply(String num1, String num2) {
        int m=num1.length(), n=num2.length();
        if(num1.equals("0") || num2.equals("0")) return "0";
        int product[] = new int[m+n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int a = Character.getNumericValue(num1.charAt(i));
                int b = Character.getNumericValue(num2.charAt(j));
                int prod = a*b, curr=prod+product[i+j+1];
                product[i+j+1] = curr%10;
                product[i+j] += curr/10;
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<m+n;i++){
            if(i==0 && product[i]==0) continue;
            sb.append(Integer.toString(product[i]));
        }
        return sb.toString();
    }

    public static void main(String args[]){
        System.out.println(multiply("2","3"));
        System.out.println(multiply("123","456"));
    }

}
