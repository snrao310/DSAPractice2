/**
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 *
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 *
 */
public class InterleavingStringLeetCode {

    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        return backtrackFunction(s1.toCharArray(),s2.toCharArray(),s3.toCharArray(),0,0,new int[s1.length()+1][s2.length()+1]);
    }

    private static boolean backtrackFunction(char[] s1, char[] s2, char[] s3, int start1, int start2, int[][] dp){
        if(start1==s1.length && start2==s2.length) return true;
        if(start1<s1.length && start2<s2.length && dp[start1][start2]!=0) return (dp[start1][start2]==1);
        boolean ans=false;
        if(start1<s1.length && s1[start1]==s3[start1+start2])
            ans |= backtrackFunction(s1,s2,s3,start1+1,start2,dp);
        if(!ans && start2<s2.length && s2[start2]==s3[start1+start2])
            ans |= backtrackFunction(s1,s2,s3,start1,start2+1,dp);
        dp[start1][start2]=ans?1:-1;
        return ans;
    }

    public static void main(String args[]){
        System.out.println(isInterleave("aabcc","dbbca","aadbbcbcac"));
        System.out.println(isInterleave("aabcc","dbbca","aadbbbaccc"));
    }
}
