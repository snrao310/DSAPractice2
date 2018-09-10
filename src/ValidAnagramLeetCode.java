/**
 *
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 *
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 */
public class ValidAnagramLeetCode {

    public static boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        char[] schars=s.toCharArray(), tchars=t.toCharArray();
        for(char c:schars) count[c-'a']++;
        for(char c:tchars) count[c-'a']--;
        for(int i:count) if(i!=0) return false;
        return true;
    }

    public static void main(String args[]){
        System.out.print(isAnagram("iamlordvoldemort","tommarvoloriddle"));
    }
}
