import java.util.HashMap;

/**
 *
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 */
public class RomanToIntegerLeetCode {

    public static int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1); map.put('V',5); map.put('X',10); map.put('L',50); map.put('C',100); map.put('D',500); map.put('M',1000);
        char[] str=s.toCharArray();
        int res=0;
        for(int i=0;i<str.length;i++){
            int val = map.get(str[i]);
            int nextVal = (i!=str.length-1)? map.get(str[i+1]): Integer.MIN_VALUE;
            if(nextVal>val){
                res+=(nextVal-val);
                i++;
            }
            else
                res+=val;
        }
        return res;
    }

    public static void main(String args[]){
        System.out.print(romanToInt("CMXLV"));
    }
}
