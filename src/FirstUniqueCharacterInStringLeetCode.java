/**
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 *
 * Note: You may assume the string contain only lowercase letters.
 *
 */
public class FirstUniqueCharacterInStringLeetCode {

    public static int firstUniqChar(String s) {
        int[] freq = new int[26];
        char[] str= s.toCharArray();
        for(char c: str)
            freq[c-'a']++;
        for(int i=0;i<str.length;i++)
            if(freq[str[i]-'a']==1) return i;
        return -1;
    }

    public static void main(String args[]){
        System.out.print(firstUniqChar("lovechild"));
    }
}
