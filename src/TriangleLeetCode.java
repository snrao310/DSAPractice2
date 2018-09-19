import java.util.Arrays;
import java.util.List;

/**
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on
 * the row below.
 *
 */
public class TriangleLeetCode {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int len=triangle.size();
        int[] dp=new int[triangle.size()];
        for(int i=0;i<triangle.size();i++) dp[i]=triangle.get(len-1).get(i);
        for(int i=triangle.size()-2;i>=0;i--){
            List<Integer> row=triangle.get(i);
            for(int j=0;j<row.size();j++){
                dp[j]=Math.min(dp[j],dp[j+1])+row.get(j);
            }
        }
        return dp[0];
    }

    public static void main(String args[]){
        List<List<Integer>> l= Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3,4),
                Arrays.asList(6,5,7),
                Arrays.asList(4,1,8,3));
        System.out.println(minimumTotal(l));
    }
}
