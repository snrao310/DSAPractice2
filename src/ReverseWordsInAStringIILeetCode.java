import java.util.Arrays;

/*
Given an input string , reverse the string word by word.

Example:

Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Note:

A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.
Follow up: Could you do it in-place without allocating extra space?
 */
public class ReverseWordsInAStringIILeetCode {

    public static void reverseWords(char[] str) {
        if(str.length==0) return;
        reverse(str,0,str.length-1);
        reverseEachWord(str);
    }

    private static void reverse(char[] str, int start, int end){
        int i=start, j=end;
        while(i<j){
            char temp=str[i];
            str[i]=str[j];
            str[j]=temp;
            i++;j--;
        }
    }

    private static void reverseEachWord(char[] str){
        int curStart=0;
        for(int i=0;i<=str.length;i++){
            if(i==str.length || str[i]==' '){
                reverse(str,curStart,i-1);
                curStart=i+1;
            }
        }
    }

    public static void main(String args[]){
        char[] str = "The Sky Is Blue".toCharArray();
        reverseWords(str);
        System.out.println(Arrays.toString(str));
    }

}
