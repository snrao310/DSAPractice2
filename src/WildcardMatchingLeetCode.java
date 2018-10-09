import java.util.Arrays;

/**
 *
 * Implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 *
 */
public class WildcardMatchingLeetCode {

    public static boolean isMatch(String s, String p) {
        return backtrackFunction(s.toCharArray(),p.toCharArray(),0,0,new int[s.length()][p.length()]);
    }

    private static boolean backtrackFunction(char[] s, char[] p, int sStart, int pStart, int[][] dp){
        if(sStart==s.length && pStart==p.length) return true;
        if(pStart==p.length) return false;
        if(sStart==s.length){
            for(int i=pStart;i<p.length;i++){
                if(p[i]!='*') return false;
            }
            return true;
        }
        if(dp[sStart][pStart]!=0) return dp[sStart][pStart]==0;

        char schar=s[sStart];
        char pchar=p[pStart];
        boolean result = false;
        if(pchar!='*'){
            if(pchar=='?')
                result= backtrackFunction(s, p, sStart+1,pStart+1,dp);
            else
                result = (schar==pchar) && backtrackFunction(s, p, sStart+1,pStart+1,dp);
        }
        else{
            for(int i=sStart;i<=s.length;i++){
                result=backtrackFunction(s,p,i,pStart+1,dp);
                if(result) break;
            }
        }
        dp[sStart][pStart]=(result)?1:-1;
        return result;
    }

    public static void main(String args[]){
        System.out.println(isMatch("aa","a"));
        System.out.println(isMatch("aa","aa"));
        System.out.println(isMatch("aaa","aa"));
        System.out.println(isMatch("ab", "?*"));
        System.out.println(isMatch("aab", "c*a*b"));
    }
}
