/**
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity
 * O(n).
 *
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 *
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 *
 */
public class MinimumWindowSubstringLeetCode {


    // 1. Use two pointers: start and end to represent a window.
    // 2. Move end to find a valid window.
    // 3. When a valid window is found, move start to find a smaller window.
    public static String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        int[] map = new int[58];
        for(int i=0;i<t.length();i++)
            map[t.charAt(i)-'A']++;
        int start=0, end=0, counter=t.length(), minLength=Integer.MAX_VALUE, beg=0;
        while(end<s.length()){
            int c=s.charAt(end)-'A';
            if(map[c]>0)
                counter--;
            map[c]--;
            while(counter==0){
                if(end-start+1<minLength){
                    beg=start;minLength=end-start+1;
                }
                c=s.charAt(start)-'A';
                if(map[c]==0)
                    counter++;
                map[c]++;
                start++;
            }
            end++;
        }
        if(minLength==Integer.MAX_VALUE) return "";
        return s.substring(beg, beg+minLength);
    }

    public static void main(String args[]){
        System.out.print(minWindow("ADOBECODEBANC","ABC"));
    }
}
