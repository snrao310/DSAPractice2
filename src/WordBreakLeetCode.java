import java.util.*;

/**
 *
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence
 * of one or more dictionary words.
 *
 *
 */
public class WordBreakLeetCode {

    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>();
        for(String word: wordDict) dict.add(word);
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return backtrackFunction(s, dict, 0,dp);
    }

    private static boolean backtrackFunction(String s, HashSet<String> dict, int start,int[] dp){
        if(dp[start]!=-1)
            return dp[start]==1;
        for(int i=start+1;i<=s.length();i++){
            String sub = s.substring(start,i);
            if(dict.contains(sub)){
                if(i==s.length() || backtrackFunction(s,dict,i,dp)) {
                    dp[start]=1;
                    return true;
                }
            }
        }
        dp[start] = 0;
        return false;
    }


    public static void main(String args[]){
        List<String > set=new ArrayList<>();
        set.add("leet");
        set.add("code");
        System.out.println(wordBreak("leetcode",set));
    }
}