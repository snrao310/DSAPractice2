import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 *
 */
public class RestoreIPAddressLeetCode {

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrackFunction(s,0,4,result,new StringBuilder());
        return result;
    }

    private static void backtrackFunction(String s, int start, int partsLeft, List<String> result, StringBuilder temp){
        int lenLeft=s.length()-start;
        if(lenLeft> partsLeft*3 || lenLeft<partsLeft) return;
        if(lenLeft==0 && partsLeft==0){
            result.add(temp.toString());
            return;
        }

        for(int i=start;i<s.length() && i<start+3;i++){
            String part = s.substring(start,i+1);
            int num = Integer.parseInt(part);
            if(Integer.toString(num).length()!=part.length() || num>255) continue;
            part = num + ((partsLeft!=1)?".":"");
            temp.append(part);
            backtrackFunction(s,i+1,partsLeft-1,result,temp);
            temp.delete(temp.length()-part.length(),temp.length());
        }
    }

    public static void main(String args[]){
        List<String> list= restoreIpAddresses("010010");
        for(String s: list){
            System.out.println(s);
        }
    }
}
