/**
 *
 * Given an input string, reverse the string word by word.
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 */
public class ReverseWordsInAStringLeetCode {
    public static String reverseWords(String s) {
        if(s.length()==0) return s;
        char[] str = s.toCharArray();
        reverse(str,0,str.length-1);
        reverseEachWord(str);
        int len = removeSpaces(str);
        return String.valueOf(str).substring(0,len);
    }

    private static void reverseEachWord(char[] str){
        int wordStart=-1;
        for(int i=0;i<=str.length;i++){
            if((i==str.length || str[i]==' ') && wordStart!=-1){
                reverse(str,wordStart,i-1);
                wordStart=-1;
            }
            else if(wordStart==-1)
                wordStart=i;
        }
    }

    private static void reverse(char[] word, int start, int end){
        while(start<end){
            char temp=word[start]; word[start]=word[end]; word[end]=temp;
            start++;end--;
        }
    }

    private static int removeSpaces(char[] str){
        boolean prevSpace=true;
        int i,j;
        for(i=0, j=0;j<str.length;j++){
            if(str[j]!=' ' || !prevSpace){
                prevSpace=(str[j]==' ');
                str[i++]=str[j];
            }
        }
        return (i==0 || str[i-1]!=' ')?i:i-1;
    }


    public static void main(String args[]){
        System.out.println(reverseWords("   a   b  c d   e  "));
    }
}
