/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharactersLeetCode {

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int result = 0;
        for(int i=0,j=0;j<s.length();j++){
            if(!set.contains(s.charAt(j))){
                result = Math.max(result,j-i+1);
                set.add(s.charAt(j));
            }
            else{
                while(s.charAt(i)!=s.charAt(j)){
                    set.remove(s.charAt(i));
                    i++;
                }
                i++;
            }
        }
        return result;
    }

    public static void main(String args[]){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

}
