import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * ((()))
 * (()())
 * (())()
 * ()(())
 * ()()()
 */
public class GenerateParanthesesLeetCode {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrackFunction("",0,0,n,result);
        return result;
    }

    private static void backtrackFunction(String tempString, int open, int closed, int max, List<String> result){
        if(open==closed && open==max){
            result.add(tempString);
            return;
        }

        if(open>closed)
            backtrackFunction(tempString+")",open,closed+1,max,result);
        if(open!=max)
            backtrackFunction(tempString+"(",open+1,closed,max,result);
    }


    public static void main(String args[]) {
        List<String> list = generateParenthesis(3);

        for (String k : list) {
            System.out.println(k);
        }

    }
}
