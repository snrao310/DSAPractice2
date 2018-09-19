import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 *
 */
public class SubsetsLeetCode {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result =new ArrayList<>();
        backtrackFunction(nums,0,result,new ArrayList<>());
        return result;
    }

    private static void backtrackFunction(int[] nums,int start,List<List<Integer>> result, List<Integer> tempList){
        result.add(new ArrayList(tempList));
        for(int i=start;i<nums.length;i++){
            tempList.add(nums[i]);
            backtrackFunction(nums,i+1,result,tempList);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String args[]){
        List<List<Integer>> list=subsets(new int[]{1,2,3});
        for(List<Integer> l:list){
            for(int i:l)
                System.out.print(i+" ");
            System.out.println();
        }
    }
}
