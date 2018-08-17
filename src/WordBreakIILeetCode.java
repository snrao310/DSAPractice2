import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to
 * construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain
 * duplicate words.
 *
 * Return all such possible sentences.
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 *
 * A solution is ["cats and dog", "cat sand dog"].
 *
 * UPDATE (2017/1/4):
 * The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code
 * definition to get the latest changes.
 *
 */
public class WordBreakIILeetCode {

    //Backtracking with dp
    //dp[i] is the list of valid solution strings for substring from ith position to end of input string.
    //For example for s="batscatsanddog", and dict = ["bats", "cat", "cats", "and", "sand", "dog"], dp[4] is
    //["cats and dog", "cat sand dog"].
    public static List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>();
        for(String st: wordDict) dict.add(st);
        List<String>[] dp = new List[s.length()];
        List<String> result = new ArrayList<>();
        backtracking(s, dict, "", result, 0, dp);
        return result;
    }

    public static void backtracking(String s, HashSet<String> dict, String tempString, List<String> result,  int start, List<String>[] dp) {
        if(start==s.length()){
            result.add(tempString);
            return;
        }
        if(dp[start]!=null) {
            for(String st: dp[start])
                result.add(tempString + " " + st);
            return;
        }

        dp[start] = new ArrayList<>();
        for(int i=start+1; i<=s.length();i++){
            String part = s.substring(start,i);
            if(dict.contains(part)){
                String newString = (tempString.length()==0)? part : tempString+" "+part;
                backtracking(s,dict,newString,result,i,dp);
                if(i==s.length())
                    dp[start].add(part);

                else{
                    for(String st: dp[i])
                        dp[start].add(part+" "+st);
                }

            }
        }
    }

    public static void main(String args[]){
        List<String> words=new ArrayList<>();
        words.add("cats"); words.add("and"); words.add("dog"); words.add("sand"); words.add("cat");
        List<String> list=wordBreak("catsanddog",words);
        for(String s:list)
            System.out.println(s);
    }
}
