/**
 *
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation
 * is counted as 1 step.)
 *
 * You have the following 3 operations permitted on a word:
 *
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 *
 */
public class EditDistanceLeetCode {

    //Standard edit distance algorithm. 1D dp because 2d is not necessary. We can resuse the same array from previous row.
    //dp[i][j] = (word1[i]==word2[j]) ? dp[i-1][j-1] :  min(dp[i-1][j-1]+1 ,dp[i-1][j]+1 ,dp[i][j-1]+1))
    public static int minDistance(String word1, String word2) {
        int[] prevDp = new int[word2.length()+1];
        int[] curDp = prevDp;
        for(int i=0;i<=word2.length();i++)
            prevDp[i]=i;
        for(int i=0;i<word1.length();i++){
            curDp = new int[word2.length()+1];
            curDp[0]=prevDp[0]+1;
            for(int j=0;j<word2.length();j++){
                int minVal = Math.min(curDp[j],prevDp[j]);
                minVal = Math.min(minVal,prevDp[j+1]);
                if(word1.charAt(i)==word2.charAt(j))
                    curDp[j+1]=prevDp[j];
                else
                    curDp[j+1]=minVal+1;
            }
            prevDp=curDp;
        }
        return curDp[word2.length()];
    }

    public static void main(String args[]){
        System.out.print(minDistance("alphabet","wolfphabemma")); //6
    }
}
