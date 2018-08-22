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
        return backtrackFunction(s, dict, 0);
    }

    private static boolean backtrackFunction(String s, HashSet<String> dict, int start){
        for(int i=start+1;i<=s.length();i++){
            String sub = s.substring(start,i);
            if(dict.contains(sub)){
                if(i==s.length()) return true;
                if(backtrackFunction(s,dict,i)) return true;
            }
        }
        return false;
    }


    public static void main(String args[]){
        List<String > set=new ArrayList<>();
        set.add("leet");
        set.add("code");
        System.out.println(wordBreak("leetcode",set));
    }
}