/**
 *
 * Write a function that takes a string as input and returns the string reversed.
 *
 * Example:
 * Given s = "hello", return "olleh".
 *
 */
public class ReverseStringLeetCode {

    //can always do return new StringBuilder(s).reverse().toString();
    public static String reverseString(String s) {
        int i=0, j=s.length()-1;
        char[] st=s.toCharArray();
        while(i<j){
            char temp=st[i]; st[i]=st[j]; st[j]=temp;
            i++; j--;
        }
        return String.valueOf(st);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("abcdefgh"));
    }
}