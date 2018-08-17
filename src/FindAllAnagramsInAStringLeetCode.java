import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than
 * 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 * Output:
 * [0, 1, 2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 */
public class FindAllAnagramsInAStringLeetCode {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length()>s.length()) return result;
        char[] sarr=s.toCharArray(), parr=p.toCharArray();
        int[] freq = new int[26];
        for(int i=0;i<parr.length;i++){
            freq[parr[i]-'a']++;
        }
        for(int i=0;i<sarr.length;i++){
            if(i>=parr.length)
                freq[sarr[i-parr.length]-'a']++;
            freq[sarr[i]-'a']--;
            if(allZeroes(freq))
                result.add(i-parr.length+1);
        }
        return result;
    }

    private static boolean allZeroes(int[] freq){
        for(int i: freq)
            if(i!=0)
                return false;
        return true;
    }

    public static void main(String args[]){
        System.out.print(findAnagrams("abab","ab"));
    }
}
