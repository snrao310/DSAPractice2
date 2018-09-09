import java.util.Arrays;

/**
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 *
 */
public class DecodeWaysLeetCode {

    public static int numDecodings(String s) {
        int[] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return backtrackFunction(s,dp,0);
    }

    private static int backtrackFunction(String s, int[] dp, int start){
        if(start==s.length()) return 1;
        if(dp[start]!=-1) return dp[start];
        int res;
        char c = s.charAt(start);
        if(c=='0') return 0;
        if(start!=s.length()-1 && (c=='1' || (c=='2' && s.charAt(start+1)<='6'))){
            res=backtrackFunction(s,dp,start+1) + backtrackFunction(s,dp,start+2);
        }
        else{
            res=backtrackFunction(s,dp,start+1);
        }
        dp[start]=res;
        return res;
    }


    public  static void main(String args[]){
        System.out.println(numDecodings("226"));
        System.out.println(numDecodings("0"));
        System.out.println(numDecodings("17"));
    }
}
